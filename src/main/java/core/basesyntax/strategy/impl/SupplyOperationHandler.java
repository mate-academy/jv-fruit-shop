package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public SupplyOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityOfStorage = fruitStorageDao.getFruitQuantity(fruit);
        int quantity = fruitTransaction.getQuantity();
        fruitStorageDao.updateFruitQuantity(fruit, quantityOfStorage + quantity);
    }
}
