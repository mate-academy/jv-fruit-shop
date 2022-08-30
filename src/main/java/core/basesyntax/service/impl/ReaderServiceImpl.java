package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        try {
            List<String> data = Files.readAllLines(Path.of(fileName));
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName + " ", e);
        }
    }
}
