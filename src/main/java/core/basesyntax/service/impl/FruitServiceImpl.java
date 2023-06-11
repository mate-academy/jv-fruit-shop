package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitTransactionReader;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final FruitStorage fruitStorage;
    private final FruitTransactionReader fruitTransactionReader;
    private final CsvFileWriter csvFileWriter;

    public FruitServiceImpl(FruitStorage fruitStorage,
                            FruitTransactionReader fruitTransactionReader,
                            CsvFileWriter csvFileWriter) {
        this.fruitStorage = fruitStorage;
        this.fruitTransactionReader = fruitTransactionReader;
        this.csvFileWriter = csvFileWriter;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            switch (transaction.getOperation()) {
                case BALANCE:
                    processBalanceTransaction(transaction);
                    break;
                case SUPPLY:
                    processSupplyTransaction(transaction);
                    break;
                case PURCHASE:
                    processPurchaseTransaction(transaction);
                    break;
                case RETURN:
                    processReturnTransaction(transaction);
                    break;
                default:
                    throw new RuntimeException("Invalid operation: " + transaction.getOperation());
            }
        }
    }

    private void processBalanceTransaction(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Fruit fruit = fruitStorage.getFruit(fruitName);
        if (fruit == null) {
            fruitStorage.addFruit(new Fruit(fruitName, quantity));
        } else {
            fruit.setQuantity(quantity);
        }
    }

    private void processSupplyTransaction(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Fruit fruit = fruitStorage.getFruit(fruitName);
        if (fruit == null) {
            fruitStorage.addFruit(new Fruit(fruitName, quantity));
        } else {
            fruit.setQuantity(fruit.getQuantity() + quantity);
        }
    }

    private void processPurchaseTransaction(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Fruit fruit = fruitStorage.getFruit(fruitName);
        if (fruit != null) {
            int updatedQuantity = fruit.getQuantity() - quantity;
            if (updatedQuantity >= 0) {
                fruit.setQuantity(updatedQuantity);
            } else {
                throw new RuntimeException("Invalid fruit quantity after purchase: " + fruitName);
            }
        } else {
            throw new RuntimeException("Fruit not found: " + fruitName);
        }
    }

    private void processReturnTransaction(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Fruit fruit = fruitStorage.getFruit(fruitName);
        if (fruit != null) {
            fruit.setQuantity(fruit.getQuantity() + quantity);
        } else {
            throw new RuntimeException("Fruit not found: " + fruitName);
        }
    }

    @Override
    public void generateReport() {
        List<Fruit> fruits = fruitStorage.getAllFruits();
        csvFileWriter.writeToFile("report.csv", fruits);
    }
}
