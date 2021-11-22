package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitSupply implements WorkWithFruits {
    @Override
    public void workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao) {
        fruitDao.get(fruitName).orElseGet(() -> fruitDao.add(new Fruit(fruitName, 0)));
        int oldCountFruit = fruitDao.getCurrentCountFruitsInStorage(fruitName);
        fruitDao.changeFruitCountInStorage(oldCountFruit + fruitNumber, fruitName);
    }
}
