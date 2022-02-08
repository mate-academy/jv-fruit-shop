package fruite.store.service.strategy;

import fruite.store.dao.StorageDao;
import fruite.store.dao.StorageDaoImpl;

public class BalanceOperationType implements OperationType {
    @Override
    public void doOpearation(String fruit, Integer quantity) {
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.addFruitToStorage(fruit, quantity);
    }
}
