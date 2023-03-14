package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public abstract class Operation {
    protected final FruitDao fruitDao;

    public Operation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    public abstract void executeOperation(String fruit, int amount);
}
