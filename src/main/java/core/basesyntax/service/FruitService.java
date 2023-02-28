package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;

public abstract class FruitService {
    protected FruitDao fruitDao;

    public abstract void moveFruit(String fruit, Integer amount);
}

