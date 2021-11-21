package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitSupply implements WorkWithFruits {
    @Override
    public void workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao) {
        Fruit fruitFromDB = fruitDao.get(fruitName);
        int oldCountFruit = fruitFromDB.getFruitCountInStorage();
        fruitFromDB.setFruitCountInStorage(oldCountFruit + fruitNumber);
    }
}
