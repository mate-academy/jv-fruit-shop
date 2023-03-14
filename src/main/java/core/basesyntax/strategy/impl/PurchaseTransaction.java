package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.strategy.Transaction;

public class PurchaseTransaction implements Transaction {
    @Override
    public void doTransaction(StorageTransaction transaction) {
        if (Storage.STORAGE.get(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("Can't do transaction, cause fruit balance "
                    + Storage.STORAGE.get(transaction.getFruit()) + " is smaller than "
                    + "current quantity " + transaction.getQuantity());
        }
        Storage.STORAGE.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
    }
}
