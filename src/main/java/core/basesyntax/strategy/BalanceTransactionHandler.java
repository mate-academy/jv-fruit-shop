package core.basesyntax.strategy;

import core.basesyntax.db.StorageDao;
import core.basesyntax.models.Transaction;

public class BalanceTransactionHandler implements TransactionHandler {
    private StorageDao storage;

    public BalanceTransactionHandler(StorageDao storageDao) {
        this.storage = storageDao;
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
        return true;
    }
}
