package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Fruit fruit = storageDao.getFromStorage(fruitTransaction.getFruitType());
        fruit.setFruitQuantity(fruit.getFruitQuantity() - fruitTransaction.getFruitQuantity());
        storageDao.updateStorage(fruit);
    }
}
