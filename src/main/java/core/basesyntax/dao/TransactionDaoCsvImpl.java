package core.basesyntax.dao;

import core.basesyntax.repository.FruitStorage;
import core.basesyntax.model.FruitTransaction;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionDaoCsvImpl implements TransactionDao {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final int INDEX_FROM_CSV_SKIP = 1;

    @Override
    public void add(FruitTransaction transaction) {
        FruitStorage.transactions.add(transaction);
    }
    @Override
    public void addAll(List<FruitTransaction> transactions) {
        FruitStorage.transactions.addAll(transactions);
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

    @Override
    public void updateStock(String fruit, int amount) {
        int newAmount = amount;
        if (FruitStorage.fruitsOnStock.get(fruit) != null) {
            newAmount = (FruitStorage.fruitsOnStock.get(fruit)) + amount;
        }
        FruitStorage.fruitsOnStock.put(fruit, newAmount);
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        switch(fields[INDEX_OPERATION].trim()) {
            case("b"):
                fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
                break;
            case("s"):
                fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
                break;
            case("r"):
                fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
                break;
            case("p"):
                fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
                break;
            }
        fruitTransaction.setFruit(fields[INDEX_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_QUANTITY]));
        return fruitTransaction;
    }
}
