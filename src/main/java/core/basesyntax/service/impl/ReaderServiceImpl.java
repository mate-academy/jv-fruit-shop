package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String pathToFile) {
        Path path = Paths.get(pathToFile);

        try {
            return Files.readAllLines(path).stream()
                    .skip(1)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Try to read from a file was unsuccessful: " + e);
        }
    }
}
