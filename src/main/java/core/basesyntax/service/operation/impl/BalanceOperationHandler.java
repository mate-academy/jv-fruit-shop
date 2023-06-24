package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public BalanceOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("Can't do a operation, because our model is "
                    + "empty!");
        }
        fruitShopDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
