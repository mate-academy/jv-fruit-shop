package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data to write cannot be null");
        }
        try {
            Files.writeString(Path.of(filePath), data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + filePath, e);
        }
    }
}
