package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;

public class BalanceTransaction implements Transaction {
    @Override
    public void doTransaction(StorageTransaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
