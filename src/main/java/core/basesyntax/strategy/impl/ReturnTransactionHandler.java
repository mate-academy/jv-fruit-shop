package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.strategy.TransactionHandler;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public void handle(StorageTransaction transaction) {
        Storage.storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
