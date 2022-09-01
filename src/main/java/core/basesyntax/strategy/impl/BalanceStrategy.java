package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.strategy.Strategy;

public class BalanceStrategy implements Strategy {
    @Override
    public void makeOperation(Transaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getValue());
    }
}
