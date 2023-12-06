package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public PurchaseOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int quantityOfStorage = fruitStorageDao.getFruitQuantity(fruit);
        if (quantity > quantityOfStorage) {
            throw new RuntimeException("There is not enough fruits in the storage.");
        }
        fruitStorageDao.updateFruitQuantity(fruit, quantityOfStorage - quantity);
    }
}
