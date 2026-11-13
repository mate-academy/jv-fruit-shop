package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, String filePath) {
        if (report == null) {
            throw new IllegalArgumentException("Report cannot be null");
        }

        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException(
                    "File path cannot be null or empty");
        }

        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Can't write file: " + filePath, e);
        }
    }
}
