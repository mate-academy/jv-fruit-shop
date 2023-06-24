package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.strategy.TransactionHandler;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void handle(StorageTransaction transaction) {
        if (Storage.storage.get(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("Can't do transaction, cause fruit balance "
                    + Storage.storage.get(transaction.getFruit()) + " is smaller than "
                    + "current quantity " + transaction.getQuantity());
        }
        Storage.storage.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
    }
}
