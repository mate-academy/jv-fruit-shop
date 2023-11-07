package core.basesyntax.operation.handler;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public BalanceOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void calculateQuantity(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int amount = fruitTransaction.getAmount();
        fruitStorageDao.updateFruitQuantity(fruit, amount);
    }
}
