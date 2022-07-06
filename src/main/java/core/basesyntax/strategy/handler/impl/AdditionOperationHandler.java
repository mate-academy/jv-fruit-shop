package core.basesyntax.strategy.handler.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class AdditionOperationHandler implements OperationHandler {
    private final FruitShopDao fruitShopDao;

    public AdditionOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitShopDao.get(fruitTransaction.getFruit()) == null) {
            fruitShopDao.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            fruitShopDao.put(fruitTransaction.getFruit(),
                    fruitShopDao.get(fruitTransaction.getFruit())
                            + fruitTransaction.getQuantity());
        }
    }
}
