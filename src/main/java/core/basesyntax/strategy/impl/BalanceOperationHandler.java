package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void makeOperation(String fruit, Integer amount) {
        Integer oldQuantity = fruitDao.getFruitQuantity(fruit);
        fruitDao.updateQuantity(fruit, oldQuantity + amount);
    }
}
