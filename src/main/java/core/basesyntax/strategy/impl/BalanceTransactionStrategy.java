package core.basesyntax.strategy.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.FruitDB;
import core.basesyntax.strategy.TransactionProcessor;

public class BalanceTransactionStrategy implements TransactionProcessor {
    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (FruitDB.FRUIT_DATA_BASE.containsKey(transaction.getFruit())) {
            quantity += FruitDB.FRUIT_DATA_BASE.get(fruit);
        }
        FruitDB.FRUIT_DATA_BASE.put(fruit, quantity);
    }
}
