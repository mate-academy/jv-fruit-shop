package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TransactionReaderServiceImpl implements TransactionReaderService {

    @Override
    public List<String> read(String fileName) {
        List<String> linesFromFile;
        try {
            linesFromFile = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + fileName);
        }
        return linesFromFile;
    }
}
