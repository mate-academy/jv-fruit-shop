package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        if (data == null || filePath == null) {
            throw new IllegalArgumentException("Data or file path cannot be null");
        }

        try {
            Files.write(Paths.get(filePath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Data cannot be written to file: " + filePath, e);
        }
    }
}
