package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.TransactionService;

public class TransactionServiceReturn implements TransactionService {
    private static final int DEFAULT_QUANTITY = 0;

    @Override
    public void applyTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = FruitStorage.storage.getOrDefault(fruit, DEFAULT_QUANTITY);
        FruitStorage.storage.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
