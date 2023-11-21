package core.basesyntax.strategy.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.FruitDB;
import core.basesyntax.strategy.TransactionProcessor;

public class BalanceTransactionStrategy implements TransactionProcessor {
    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (FruitDB.FRUIT_DATA_BASE.containsKey(fruit)) {
            FruitDB.FRUIT_DATA_BASE.get(fruit);
        } else {
            throw new RuntimeException("Warning: Not enough " + fruit + " in inventory.");
        }
    }
}
