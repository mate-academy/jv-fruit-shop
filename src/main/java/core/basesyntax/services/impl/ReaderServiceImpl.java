package core.basesyntax.services.impl;

import core.basesyntax.services.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            List<String> allLines = Files.readAllLines(path);
            allLines.remove(0);
            return allLines;
        } catch (IOException ex) {
            throw new RuntimeException("Invalid file path: " + fileName, ex);
        }
    }
}
