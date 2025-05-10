package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public ReturnOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int quantityOfStorage = fruitStorageDao.getFruitQuantity(fruit);
        fruitStorageDao.updateFruitQuantity(fruit, quantityOfStorage + quantity);
    }
}
