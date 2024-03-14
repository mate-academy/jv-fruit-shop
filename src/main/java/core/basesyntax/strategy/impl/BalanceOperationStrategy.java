package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationStrategy implements OperationHandler {
    private static final int SHIFT_START = 0;
    private final FruitDao fruitDao;

    public BalanceOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = new Fruit(fruitName, quantity, SHIFT_START);
        fruitDao.add(fruit);
    }
}
