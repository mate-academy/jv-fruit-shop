package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruit, int quantity) {
        fruitDao.add(fruit, fruitDao.getQuantity(fruit) + quantity);
    }
}
