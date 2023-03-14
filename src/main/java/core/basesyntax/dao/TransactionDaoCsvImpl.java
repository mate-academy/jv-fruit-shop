package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.repository.TransactionDB;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionDaoCsvImpl implements TransactionDao {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_AMOUNT = 2;
    private static final int INDEX_FROM_CSV_SKIP = 1;
    private static final String SEPARATOR = ",";

    @Override
    public void add(FruitTransaction transaction) {
        TransactionDB.transactions.add(transaction);
    }

    @Override
    public List<FruitTransaction> get(String fileName) {
        List<String> transactions;
        try {
            transactions = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName);
        }
        return transactions.stream()
                .skip(INDEX_FROM_CSV_SKIP)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(SEPARATOR);
        String operation = fields[INDEX_OPERATION].trim();
        String fruit = fields[INDEX_FRUIT];
        int amount = Integer.parseInt(fields[INDEX_AMOUNT]);
        return new FruitTransaction(FruitTransaction.Operation.getByCode(operation), fruit, amount);
    }
}
