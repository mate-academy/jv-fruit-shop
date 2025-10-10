package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new RuntimeException("File path must be provided and cannot be empty");
        }
        Path path = Path.of(fileName);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
    }
}
