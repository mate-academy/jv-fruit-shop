package core.basesyntax.strategy.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.FruitDB;
import core.basesyntax.strategy.TransactionProcessor;

public class BalanceTransactionStrategy implements TransactionProcessor {
    @Override
    public void process(FruitTransaction transaction) {
        FruitDB.FRUIT_DATA_BASE.put(transaction.getFruit(), transaction.getQuantity());
    }
}
