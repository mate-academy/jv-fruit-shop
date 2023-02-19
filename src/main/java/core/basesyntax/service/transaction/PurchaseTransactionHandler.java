package core.basesyntax.service.transaction;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    private StorageDao storageDao;

    public PurchaseTransactionHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeTransaction(Transaction transaction) {
        storageDao.removeFromStorage(transaction.getFruitName(), transaction.getQuantity());
    }
}
