package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void calculate(String fruit, int value) {
        fruitDao.add(fruit, value);
    }
}
