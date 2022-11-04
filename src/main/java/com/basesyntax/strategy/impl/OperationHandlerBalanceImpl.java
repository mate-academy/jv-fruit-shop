package com.basesyntax.strategy.impl;

import com.basesyntax.dao.FruitDao;
import com.basesyntax.dao.FruitDaoImpl;
import com.basesyntax.model.Fruit;
import com.basesyntax.strategy.OperationHandler;

public class OperationHandlerBalanceImpl implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(Fruit fruit, int amount) {
        fruitDao.put(fruit, amount);
    }
}
