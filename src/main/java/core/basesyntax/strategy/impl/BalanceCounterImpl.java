package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.Counter;

public class BalanceCounterImpl implements Counter {
    @Override
    public void apply(Transaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
