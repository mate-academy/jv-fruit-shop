package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new RuntimeException("File path must be provided and cannot be empty");
        }
        if (data == null) {
            throw new RuntimeException("Data to write cannot be null");
        }
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + fileName, e);
        }
    }
}
