package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceCsvImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> transactions = new ArrayList<>();
        try {
            transactions = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath);
        }
        transactions.remove(0);
        return transactions;
    }
}
