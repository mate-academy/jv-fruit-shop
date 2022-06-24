package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;

public class ReturnOperationHandler implements FruitsOperationHandler {
    private StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        storageDao.update(name, storageDao.get(name) + addNumber);
    }
}
