package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.strategy.Transaction;

public class PurchaseTransaction implements Transaction {
    private static final int ZERO_QUANTITY = 0;

    @Override
    public void doTransaction(StorageTransaction transaction) {
        if (Storage.STORAGE.get(transaction.getFruit()) >= transaction.getQuantity()) {
            Storage.STORAGE.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
        } else {
            Storage.STORAGE.put(transaction.getFruit(), ZERO_QUANTITY);
        }
    }
}
