package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileService {
    private static final String TITLE = "Fruit, quantity";
    private static final String SEPARATOR = ",";

    @Override
    public void writeToFile(String fileName) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            StringBuilder reportBuilder = new StringBuilder(TITLE).append(System.lineSeparator());

            for (Fruit fruits : Storage.fruits.values()) {
                reportBuilder
                        .append(fruits.getName())
                        .append(SEPARATOR)
                        .append(fruits.getQuantity())
                        .append(System.lineSeparator());
            }
            byte[] bytes = reportBuilder.toString().getBytes();

            outputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write report to file: " + fileName, e);
        }
    }

    @Override
    public List<String> readFile(String fileName) {
        List<String> documentation = new ArrayList<>();
        InputStream inputStream = FileServiceImpl.class.getClassLoader()
                .getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new RuntimeException("File not found: " + fileName);
        }

        try (Scanner scanner = new Scanner(inputStream)) {
            // Skip the title line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                documentation.add(scanner.nextLine());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading file " + fileName, e);
        }

        return documentation;
    }
}
