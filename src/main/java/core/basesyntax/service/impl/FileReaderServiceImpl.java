package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String path) {
        Path pathToInput = Path.of(path);
        try {
            return Files.readAllLines(pathToInput);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + path, e);
        }
    }
}
