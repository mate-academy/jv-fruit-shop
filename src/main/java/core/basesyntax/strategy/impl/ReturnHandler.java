package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.strategy.FruitTransactionHandler;

public class ReturnHandler implements FruitTransactionHandler {
    private final FruitDao fruitDao;

    public ReturnHandler() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handleTransaction(String fruit, int quantity) {
        fruitDao.saveQuantity(fruit, (fruitDao.getQuantityByName(fruit)
                + quantity));
    }
}
