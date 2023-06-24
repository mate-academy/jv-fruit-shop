package core.basesyntax.service.transaction;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;

public class SupplyTransactionHandler implements TransactionHandler {
    private StorageDao storageDao;

    public SupplyTransactionHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(Transaction transaction) {
        Integer currentQuantity = storageDao.getFruitsFromStorage()
                .get(transaction.getFruitName());
        storageDao.updateStorage(transaction.getFruitName(), transaction.getQuantity()
                + currentQuantity);
    }
}
