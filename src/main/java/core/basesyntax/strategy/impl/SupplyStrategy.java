package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.Strategy;

public class SupplyStrategy implements Strategy {
    @Override
    public void makeOperation(Transaction transaction) {
        Integer previousValue = Storage.fruits.get(transaction.getFruit());
        Storage.fruits.put(transaction.getFruit(), previousValue + transaction.getValue());
    }
}
