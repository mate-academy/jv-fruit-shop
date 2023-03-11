package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;

public class PurchaseTransaction implements Transaction {
    @Override
    public void doTransaction(StorageTransaction transaction) {
        Storage.storage.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
    }
}
