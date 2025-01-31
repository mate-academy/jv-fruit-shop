package dao;

import db.Storage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import model.FruitTransaction;

public class TransactionDaoImpl implements TransactionsDao {

    private final Map<FruitTransaction.Operation, BiConsumer<FruitTransaction, FruitTransaction>> operationHandlers
            = new HashMap<>();

    public TransactionDaoImpl() {
        operationHandlers.put(FruitTransaction.Operation.BALANCE, (
                fruit,
                transaction) -> fruit.setQuantity(transaction.getQuantity()));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, (
                fruit,
                transaction) -> fruit.setQuantity(fruit.getQuantity() + transaction.getQuantity()));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, (
                fruit,
                transaction) -> fruit.setQuantity(Math.max(0, fruit.getQuantity() - transaction.getQuantity())));
        operationHandlers.put(FruitTransaction.Operation.RETURN, (
                fruit,
                transaction) -> fruit.setQuantity(fruit.getQuantity() + transaction.getQuantity()));
    }

    @Override
    public void processTransaction(FruitTransaction transaction) {
        FruitTransaction fruit = findOrCreateFruit(transaction);
        operationHandlers.getOrDefault(transaction.getOperation(), (f, t) -> {
            throw new IllegalArgumentException("Unknown operation: " + t.getOperation());
        }).accept(fruit, transaction);
    }

    @Override
    public void addTransactionInfo(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }

    @Override
    public FruitTransaction getTransaction(String fruitName) {
        return Storage.transactions.stream()
                .filter(transaction -> transaction.getFruit().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    private FruitTransaction findOrCreateFruit(FruitTransaction transaction) {
        return Optional.ofNullable(getTransaction(transaction.getFruit()))
                .orElseGet(() -> {
                    addTransactionInfo(transaction);
                    return transaction;
                });
    }

    public void exportToCsv(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("fruit,quantity\n");
            for (FruitTransaction fruit : Storage.transactions) {
                writer.append(fruit.getFruit())
                        .append(",")
                        .append(String.valueOf(fruit.getQuantity()))
                        .append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to CSV file: " + filePath, e);
        }
    }
}
