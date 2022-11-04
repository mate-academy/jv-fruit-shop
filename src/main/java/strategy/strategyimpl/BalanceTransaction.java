package strategy.strategyimpl;

import dao.StorageDao;
import strategy.TransactionStrategy;

public class BalanceTransaction implements TransactionStrategy {
    private StorageDao storageDao;

    public BalanceTransaction(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storageDao.add(fruit, quantity);
    }
}
