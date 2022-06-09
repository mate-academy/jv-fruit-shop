package core.basesyntax.service.impl;

import static core.basesyntax.model.FruitTransaction.Operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements FileReaderService {
    @Override
    public List<FruitTransaction> readTransactionsFromFile(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("filePath cannot be null");
        }
        try (var rows = Files.lines(Paths.get(filePath))) {
            return rows
                    .dropWhile(row -> !row.contains("type,fruit,quantity"))
                    .skip(1)
                    .filter(row -> !row.isBlank())
                    .map(this::createNewFruitTransaction)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file: " + filePath, e);
        }
    }

    private FruitTransaction createNewFruitTransaction(String line) {
        String[] transactionFields = line.trim().split(",");
        if (transactionFields.length < 3) {
            throw new IllegalArgumentException("Fruit quantity cannot be empty");
        }
        if (transactionFields[0].isBlank()) {
            throw new IllegalArgumentException("Fruit operation type cannot be empty");
        }
        if (transactionFields[1].isBlank()) {
            throw new IllegalArgumentException("Fruit name cannot be empty");
        }
        return new FruitTransaction(
                Operation.retrieveByOperation(transactionFields[0]),
                new Fruit(transactionFields[1], Integer.parseInt(transactionFields[2])));
    }
}
