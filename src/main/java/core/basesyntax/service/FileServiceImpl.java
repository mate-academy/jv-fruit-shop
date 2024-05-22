package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruits;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileService {
    private static final String TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public FileServiceImpl() {
    }

    @Override
    public void writeToFile(String fileName) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            StringBuilder reportBuilder = new StringBuilder(TITLE).append(System.lineSeparator());

            for (Fruits fruits : Storage.fruits) {
                reportBuilder
                        .append(fruits.getName())
                        .append(SEPARATOR)
                        .append(fruits.getQuantity())
                        .append(System.lineSeparator());
            }
            byte[] bytes = reportBuilder.toString().getBytes();

            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readFile(String fileName) {
        List<String> documentation = new ArrayList<>();
        try (InputStream inputStream = FileServiceImpl.class
                .getClassLoader().getResourceAsStream(fileName);
                Scanner scanner = new Scanner(inputStream)) {

            // Skip the title line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                documentation.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + e);
        } catch (IOException e) {
            throw new RuntimeException("IO Exception " + e);
        }
        return documentation;
    }
}
