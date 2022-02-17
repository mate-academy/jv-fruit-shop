package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruitName, int amount, StorageDao storageDao) {
        storageDao.add(fruitName, amount);
    }
}
