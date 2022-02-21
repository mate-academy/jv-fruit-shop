package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit apply(int fruitNumber, String fruitName) {
        Fruit newFruit = new Fruit(fruitName, fruitNumber);
        fruitDao.get(fruitName).ifPresentOrElse(
                f -> {
                    throw new RuntimeException("Fruit name should be individual.");
                },
                () -> fruitDao.add(newFruit));
        return newFruit;
    }
}
