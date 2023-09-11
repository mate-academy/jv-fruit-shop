package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void execute(String fruit, int quantity) {
        fruitDao.add(fruit, quantity);
    }
}
