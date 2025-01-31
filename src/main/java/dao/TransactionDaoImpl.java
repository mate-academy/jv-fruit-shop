package dao;

import db.Storage;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Optional;
import model.FruitTransaction;

public class TransactionDaoImpl implements TransactionsDao {

    @Override
    public void processTransaction(FruitTransaction transaction) {
        FruitTransaction fruit = findOrCreateFruit(transaction);

        switch (transaction.getOperation()) {
            case BALANCE:
                fruit.setQuantity(transaction.getQuantity());
                break;
            case SUPPLY:
                fruit.setQuantity(fruit.getQuantity() + transaction.getQuantity());
                break;
            case PURCHASE:
                fruit.setQuantity(Math.max(0, fruit.getQuantity() - transaction.getQuantity()));
                break;
            case RETURN:
                fruit.setQuantity(fruit.getQuantity() + transaction.getQuantity());
                break;
        }
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
