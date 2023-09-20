package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruit, int quantity) {
        fruitDao.add(fruit, quantity);
    }
}
