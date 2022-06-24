package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;

public class PurchaseOperationHandler implements FruitsOperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        if (storageDao.get(name) < addNumber) {
            throw new RuntimeException("There are not enough fruits"
                    + " to purchase, actual quantity :" + storageDao.get(name));
        }
        storageDao.update(name, storageDao.get(name) - addNumber);
    }
}
