package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("File path can't be null or empty");
        }
        Path path = Path.of(filePath);

        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + filePath, e);
        }
    }
}
