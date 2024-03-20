package core.basesyntax.service.impl;

import core.basesyntax.exception.FileReaderException;
import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new FileReaderException("Error reading from a file: " + filePath, e);
        }
    }
}
