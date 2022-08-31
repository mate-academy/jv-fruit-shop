package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class FruitPurchaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public FruitPurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        int incomeAmount = fruitTransaction.getQuantity();
        int fruitsTotalBalance = fruitDao.get(fruitTransaction.getFruitName()).getQuantity();
        if (fruitsTotalBalance - incomeAmount < 0) {
            throw new RuntimeException("Not enough fruits in shop");
        }

        fruitDao.subtract(new Fruit(fruitTransaction.getFruitName(),
                fruitTransaction.getQuantity()));
    }
}
