package core.basesyntax.service.transaction;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;

public class ReturnTransactionHandler implements TransactionHandler {
    private StorageDao storageDao;

    public ReturnTransactionHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(Transaction transaction) {
        storageDao.updateStorage(transaction.getFruitName(), transaction.getQuantity());
    }
}
