package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruit, int quantity) {
        fruitDao.add(fruit, fruitDao.getQuantity(fruit) + quantity);
    }
}
