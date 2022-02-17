package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public class InitAmountHandler implements OperationHandler {
    @Override
    public void processData(FruitDao fruitDao, Fruit fruit, int quantity) {
        fruitDao.addNewFruit(fruit, quantity);
    }
}
