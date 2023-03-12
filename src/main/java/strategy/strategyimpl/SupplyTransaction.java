package strategy.strategyimpl;

import dao.StorageDao;
import strategy.TransactionStrategy;

public class SupplyTransaction implements TransactionStrategy {
    private StorageDao storageDao;

    public SupplyTransaction(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(String fruit, int quantity) {
        if (!storageDao.hasFruit(fruit)) {
            storageDao.add(fruit, quantity);
        } else {
            int oldValue = storageDao.get(fruit);
            int newValue = oldValue + quantity;
            storageDao.update(fruit, newValue);

        }
    }
}
