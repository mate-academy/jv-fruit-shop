package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file " + fileName, e);
        }
        return lines;
    }
}
