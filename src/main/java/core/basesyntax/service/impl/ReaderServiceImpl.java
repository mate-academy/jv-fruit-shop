package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private List<String> operations;

    @Override
    public List<String> readFromFile(String inputFileName) {
        try {
            operations = Files.readAllLines(Path.of(inputFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read date from file " + inputFileName + e);
        }
        return operations;
    }

}
