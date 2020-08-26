package core.basesyntax.service;

import core.basesyntax.AbstractTransaction;
import core.basesyntax.FruitBatch;
import core.basesyntax.FruitStorage;
import java.util.List;
import java.util.Map;

public class UpdateFruitStorageService {

    public void updateStock(List<AbstractTransaction> transactions) {
        Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
        for (AbstractTransaction transaction : transactions) {
            FruitBatch fruit = new FruitBatch(transaction.getFruitType(),
                    transaction.getDate());
            if (transaction.getTransactionType().equals(TransactionLogService.SUPPLY)
                    || transaction.getTransactionType().equals(TransactionLogService.RETURN)) {
                if (fruits.containsKey(fruit)) {
                    fruits.put(fruit,
                            fruits.get(fruit) + transaction.getQuantity());
                } else {
                    fruits.put(fruit, transaction.getQuantity());
                }
            }
            if (transaction.getTransactionType().equals(TransactionLogService.BUY)) {
                for (Map.Entry<FruitBatch, Integer> entry :
                        fruits.entrySet()) {
                    if (entry.getKey().getFruitType().equals(fruit.getFruitType())) {
                        if (entry.getKey().getExpiryDate().isAfter(transaction.getDate())) {
                            if (entry.getValue() < transaction.getQuantity()) {
                                throw new RuntimeException("Arithmetic "
                                        + "error. There wasn't"
                                        + " enough fruit in the store to "
                                        + "make the purchase.");
                            }
                            entry.setValue(entry.getValue() - transaction.getQuantity());
                        }
                    }
                }
            }
        }
    }
}
