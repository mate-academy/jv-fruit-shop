package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public class InitAmountHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl(Storage.getStorageOfFruits());

    @Override
    public void processData(Fruit fruit, int quantity) {
        fruitDao.addNewFruit(fruit, quantity);
    }
}
