package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int unpdatedQuantity = storageDao.getQuantity(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        storageDao.add(fruitTransaction.getFruit(), unpdatedQuantity);
    }
}
