package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("The file path cannot be empty");
        }
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the file at the path: " + filePath, e);
        }
    }
}
