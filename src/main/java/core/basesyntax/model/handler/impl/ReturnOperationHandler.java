package core.basesyntax.model.handler.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.handler.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = fruitStorageDao.getFruitQuantity(fruit);
        int amount = transaction.getAmount();
        fruitStorageDao.updateFruitQuantity(fruit, quantity + amount);
    }
}
