package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final String EXCEPTION_MESSAGE = "You can't buy this amount of fruits!";

    @Override
    public void operate(String fruit, int quantity, FruitStorageDao fruitStorageDao) {
        int quantityAfterPurchase = fruitStorageDao.getQuantity(fruit) - quantity;
        if (quantityAfterPurchase < 0) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        fruitStorageDao.add(fruit, quantityAfterPurchase);
    }
}
