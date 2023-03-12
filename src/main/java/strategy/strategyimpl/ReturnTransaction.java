package strategy.strategyimpl;

import dao.StorageDao;
import strategy.TransactionStrategy;

public class ReturnTransaction implements TransactionStrategy {
    private StorageDao storageDao;

    public ReturnTransaction(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(String fruit, int quantity) {
        if (!storageDao.hasFruit(fruit)) {
            throw new RuntimeException("There is no such fruit" + fruit);
        }
        int oldValue = storageDao.get(fruit);
        int newValue = oldValue + quantity;
        storageDao.update(fruit, newValue);
    }
}

