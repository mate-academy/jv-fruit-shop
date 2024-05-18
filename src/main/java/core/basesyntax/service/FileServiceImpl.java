package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileService {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    public FileServiceImpl() {
    }

    @Override
    public void writeToFile(String filename) {
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            StringBuilder reportBuilder = new StringBuilder(HEADER).append(System.lineSeparator());

            for (Fruit fruit : Storage.fruits) {
                reportBuilder
                        .append(fruit.getName())
                        .append(SEPARATOR)
                        .append(fruit.getQuantity())
                        .append(System.lineSeparator());
            }
            byte[] bytes = reportBuilder.toString().getBytes();

            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readFile(String filename) {
        List<String> records = new ArrayList<>();
        try (InputStream inputStream = FileServiceImpl.class
                .getClassLoader().getResourceAsStream(filename);
                Scanner scanner = new Scanner(inputStream)) {

            // Skip the title line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                records.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + e);
        } catch (IOException e) {
            throw new RuntimeException("IO Exception " + e);
        }
        return records;
    }
}
