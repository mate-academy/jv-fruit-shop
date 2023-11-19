package core.basesyntax.strategy.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.FruitDB;
import core.basesyntax.strategy.TransactionProcessor;

public class PurchaseTransactionStrategy implements TransactionProcessor {
    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (FruitDB.FRUIT_DATA_BASE.containsKey(fruit)) {
            int currentQuantity = FruitDB.FRUIT_DATA_BASE.get(fruit);
            if (currentQuantity >= quantity) {
                FruitDB.FRUIT_DATA_BASE.put(fruit, currentQuantity - quantity);
            } else {
                System.out.println("Warning: Not enough " + fruit + " in inventory.");
            }
        } else {
            System.out.println("Warning: " + fruit + " not found in inventory.");
        }
    }
}
