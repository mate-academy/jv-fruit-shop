package core.basesyntax.services.impl;

import core.basesyntax.services.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            return Files.readAllLines(path);
        } catch (IOException ex) {
            throw new RuntimeException("Invalid file path: " + fileName, ex);
        }
    }
}
