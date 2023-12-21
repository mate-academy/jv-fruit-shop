package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.TransactionService;

public class TransactionServiceSupply implements TransactionService {
    @Override
    public void applyTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = FruitStorage.storage.getOrDefault(fruit, 0);
        FruitStorage.storage.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
