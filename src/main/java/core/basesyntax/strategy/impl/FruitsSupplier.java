package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class FruitsSupplier implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public FruitsSupplier(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void executeOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityOfStorage = fruitStorageDao.getFruitQuantity(fruit);
        int quantity = fruitTransaction.getQuantity();
        fruitStorageDao.updateFruitQuantity(fruit, quantityOfStorage + quantity);
    }
}
