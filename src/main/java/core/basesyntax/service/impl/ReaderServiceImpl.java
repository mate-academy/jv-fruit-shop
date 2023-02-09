package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fromFilePath) {
        List<String> inputData;
        Path path = Path.of(fromFilePath);
        try {
            inputData = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + path, e);
        }
        return inputData;
    }
}