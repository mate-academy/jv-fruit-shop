package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void doOperation(String fruitType, String quantity) {
        Fruit fruit = new Fruit(fruitType);
        fruitDao.addFruit(fruit);
        fruitDao.addQuantity(fruit, Integer.parseInt(quantity));
    }
}
