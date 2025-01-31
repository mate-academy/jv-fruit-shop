package dao;

import db.Storage;
import model.FruitTransaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

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
//                default:
//                    System.out.println("Unknown operation: " + transaction.getOperation());
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

        public void exportToCSV(String filePath) {
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.append("fruit,quantity\n");
                for (FruitTransaction fruit : Storage.transactions) {
                    writer.append(fruit.getFruit()).append(",").append(String.valueOf(fruit.getQuantity())).append("\n");
                }
                System.out.println("Exported inventory to " + filePath);
            } catch (IOException e) {
                throw new RuntimeException("Error writing to CSV file: " + filePath, e);
            }
        }
}
