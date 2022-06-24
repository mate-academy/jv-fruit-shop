package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;

public class SupplyOperationHandler implements FruitsOperationHandler {
    private StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        storageDao.update(name, storageDao.get(name) + addNumber);
    }

}
