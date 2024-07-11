package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readFile(String fileName) {
        try {
            // Читаємо всі рядки з файлу і повертаємо їх у вигляді списку
            return Files.readAllLines(Paths.get(getClass().getClassLoader()
                    .getResource(fileName).toURI()));
        } catch (Exception e) {
            throw new RuntimeException("Error reading file " + fileName, e);
        }
    }
}
