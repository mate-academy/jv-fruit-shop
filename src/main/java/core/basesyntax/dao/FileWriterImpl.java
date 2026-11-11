package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("The path to the source file cannot be empty");
        }

        try {
            Files.writeString(Path.of(filePath), data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write data to the file: " + filePath, e);
        }
    }
}
