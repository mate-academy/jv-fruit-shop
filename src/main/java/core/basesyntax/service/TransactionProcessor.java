package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class TransactionProcessor {
    private Storage storage;

    private TransactionProcessor(Storage storage) {
        this.storage = storage;
    }

    public void processTransaction(FruitTransaction transaction) {
        storage.getOperationMap()
                .get(transaction.getOperation())
                .processTransaction(transaction,storage);
    }

    public static TransactionProcessor of(Storage storage) {
        return new TransactionProcessor(storage);
    }

}
