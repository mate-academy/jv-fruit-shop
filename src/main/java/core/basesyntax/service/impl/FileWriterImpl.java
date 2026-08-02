package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or blank");
        }
        Path path = Path.of(filePath);
        Path parent = path.getParent();
        try {
            if (parent != null) {
                Files.createDirectories(parent);
            }
            Files.writeString(path, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file by path: " + filePath, e);
        }
    }
}
