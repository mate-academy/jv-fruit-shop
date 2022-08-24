package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final String FILE_FROM_NAME = "src/main/resources/morningInfo.csv";
    private static final String DATA_SEPARATOR = ",";
    private static final int COLUMN_WITH_OPERATION = 0;
    private static final int COLUMN_WITH_NAME = 1;
    private static final int COLUMN_WITH_QUANTITY = 2;

    @Override
    public List<FruitTransaction> readTransactionFromFile() {
        List<String> dailyTransactions = new ArrayList<>();
        try {
            dailyTransactions = Files.readAllLines(Path.of(FILE_FROM_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + FILE_FROM_NAME, e);
        }
        return dailyTransactions.stream()
                .skip(1)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(DATA_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        switch (fields[COLUMN_WITH_OPERATION]) {
            case "b":
                fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
                break;
            case "s":
                fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
                break;
            case "p":
                fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
                break;
            case "r":
            default :
                fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        }
        fruitTransaction.setFruitName(fields[COLUMN_WITH_NAME]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[COLUMN_WITH_QUANTITY]));
        return fruitTransaction;
    }
}
