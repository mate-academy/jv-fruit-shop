package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class FruitsPurchaser implements OperationHandler {
    private static final String NOT_ENOUGH_FRUITS_IN_STORAGE
            = "There is not enough fruits in the storage.";
    private FruitStorageDao fruitStorageDao;

    public FruitsPurchaser(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void executeOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int quantityOfStorage = fruitStorageDao.getFruitQuantity(fruit);
        if (quantity > quantityOfStorage) {
            throw new RuntimeException(NOT_ENOUGH_FRUITS_IN_STORAGE);
        }
        fruitStorageDao.updateFruitQuantity(fruit, quantityOfStorage - quantity);
    }
}
