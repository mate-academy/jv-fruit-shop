package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.TransactionService;

public class TransactionServiceBalance implements TransactionService {
    @Override
    public void applyTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (FruitStorage.storage.containsKey(fruit)) {
            throw new RuntimeException("Error in data!"
                    + " Balance for " + fruit + " has been set before.");
        }
        FruitStorage.storage.put(fruit, transaction.getQuantity());
    }
}
