package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String filePath) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + filePath, e);
        }
    }
}
