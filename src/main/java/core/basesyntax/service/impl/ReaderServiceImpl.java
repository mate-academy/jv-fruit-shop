package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromCsvFile(String filePath) {
        Path path = Paths.get(filePath);
        List<String> transactions;

        try {
            transactions = Files.readAllLines(path);
            transactions.remove(0);
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file: " + filePath, e);
        }

        return transactions;
    }
}
