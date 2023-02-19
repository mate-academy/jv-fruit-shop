package core.basesyntax.service.transaction;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;

public class BalanceTransactionHandler implements TransactionHandler {
    private StorageDao storageDao;

    public BalanceTransactionHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(Transaction transaction) {
        storageDao.addToStorage(transaction.getFruitName(), transaction.getQuantity());
    }
}
