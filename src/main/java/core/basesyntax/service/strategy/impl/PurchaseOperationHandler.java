package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int updatedQuantity = storageDao.getQuantity(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        storageDao.add(fruitTransaction.getFruit(), updatedQuantity);
    }
}
