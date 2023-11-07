package core.basesyntax.operation.handler;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public ReturnOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void calculateQuantity(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = fruitStorageDao.getFruitQuantity(fruit);
        int amount = transaction.getAmount();
        fruitStorageDao.updateFruitQuantity(fruit, quantity + amount);
    }
}
