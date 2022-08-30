package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String inputFile) {
        List<String> inputFruits;
        try {
            inputFruits = Files.readAllLines(Paths.get(inputFile));
        } catch (IOException e) {
            throw new RuntimeException("No such file at " + inputFile, e);
        }
        return inputFruits;
    }
}
