package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    public List<String> read(String filePath) {
        try {
            Path inputPath = Paths.get(filePath);
            return Files.readAllLines(inputPath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filePath, e);
        }
    }
}
