package strategy.strategyimpl;

import dao.StorageDao;
import java.util.NoSuchElementException;
import strategy.TransactionStrategy;

public class PurchaseTransaction implements TransactionStrategy {
    private StorageDao storageDao;

    public PurchaseTransaction(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(String fruit, int quantity) {
        if (!storageDao.hasFruit(fruit)) {
            throw new NoSuchElementException("There is no such fruit" + fruit);
        }
        int oldValue = storageDao.get(fruit);
        int newValue = oldValue - quantity;
        if (newValue < 0) {
            throw new RuntimeException("No enough fruits in store");
        }
        storageDao.update(fruit, newValue);
    }
}
