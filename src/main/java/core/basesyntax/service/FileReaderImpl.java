package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readReport(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("FilePath cannot be null");
        }
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file: " + filePath, e);
        }
    }
}
