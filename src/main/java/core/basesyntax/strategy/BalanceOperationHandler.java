package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;

public class BalanceOperationHandler implements FruitsOperationHandler {
    private StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        storageDao.update(name, addNumber);
    }
}
