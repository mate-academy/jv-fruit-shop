package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.strategy.FruitTransactionHandler;

public class BalanceHandler implements FruitTransactionHandler {
    private final FruitDao fruitDaoDao;

    public BalanceHandler() {
        this.fruitDaoDao = new FruitDaoImpl();
    }

    @Override
    public void handleTransaction(String fruit, int quantity) {
        fruitDaoDao.saveQuantity(fruit, quantity);
    }
}
