package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, Path filePath) {
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            Files.write(filePath, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(String.format("Can't write in file: '%s'.", filePath), e);
        }
    }
}
