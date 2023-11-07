package core.basesyntax.operation.handler;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.exception.NegativeBalanceException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int EMPTY_STORAGE_VALUE = 0;
    private FruitStorageDao fruitStorageDao;

    public PurchaseOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void calculateQuantity(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = fruitStorageDao.getFruitQuantity(transaction.getFruit());
        int amount = transaction.getAmount();
        if (quantity == EMPTY_STORAGE_VALUE) {
            throw new NegativeBalanceException("Can't purchase because storage is empty");
        }
        if (quantity < amount) {
            throw new NegativeBalanceException("Can't purchase. Balance can't be negative");
        }
        fruitStorageDao.updateFruitQuantity(fruit, quantity - amount);
    }
}
