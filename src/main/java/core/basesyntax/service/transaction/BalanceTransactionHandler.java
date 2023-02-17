package core.basesyntax.service.transaction;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Transaction;

public class BalanceTransactionHandler implements TransactionHandler{
    private StorageDao storageDao;

    public BalanceTransactionHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeTransaction(Transaction transaction) {
        storageDao.addToStorage(transaction);
    }
}
