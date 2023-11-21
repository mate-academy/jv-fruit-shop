package core.basesyntax.strategy.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.FruitDB;
import core.basesyntax.strategy.TransactionProcessor;

public class PurchaseTransactionStrategy implements TransactionProcessor {
    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int transactionQuantity = transaction.getQuantity();
        int dbQuantity = FruitDB.FRUIT_DATA_BASE.getOrDefault(fruit, 0);
        int newQuantity = dbQuantity - transactionQuantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Warning: Not enough " + fruit + " in inventory.");
        }
        FruitDB.FRUIT_DATA_BASE.put(fruit, newQuantity);
    }
}
