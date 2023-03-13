package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.strategy.Transaction;

public class SupplyTransaction implements Transaction {
    @Override
    public void doTransaction(StorageTransaction transaction) {
        Storage.STORAGE.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
