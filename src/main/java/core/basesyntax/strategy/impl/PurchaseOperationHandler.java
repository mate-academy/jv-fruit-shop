package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer fruitQuantity = fruitDao.getQuantity(fruit);
        Integer purchaseQuantity = transaction.getQuantity();
        if (fruitQuantity - purchaseQuantity < 0) {
            throw new RuntimeException("You have only " + fruitQuantity + " fruits");
        }
        fruitDao.update(fruit, fruitQuantity - purchaseQuantity);
    }
}
