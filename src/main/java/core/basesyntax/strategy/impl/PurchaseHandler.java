package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.strategy.FruitTransactionHandler;

public class PurchaseHandler implements FruitTransactionHandler {
    private final FruitDao fruitDaoDao;

    public PurchaseHandler() {
        this.fruitDaoDao = new FruitDaoImpl();
    }

    @Override
    public void handleTransaction(String fruit, int quantity) {
        fruitDaoDao.saveQuantity(fruit, (fruitDaoDao.getQuantityByName(fruit)
                - quantity));
    }
}
