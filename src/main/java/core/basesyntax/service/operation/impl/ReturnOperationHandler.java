package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public ReturnOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("Can't do a operation, because our model is "
                    + "empty!");
        }
        String fruit = fruitTransaction.getFruit();
        int amount = fruitShopDao.get(fruit);
        int result = amount + fruitTransaction.getQuantity();
        fruitShopDao.add(fruit, result);
    }
}
