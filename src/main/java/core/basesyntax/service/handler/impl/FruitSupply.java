package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitSupply implements WorkWithFruits {
    @Override
    public Fruit workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao) {
        Fruit currentFruit = fruitDao.get(fruitName).orElseGet(() -> fruitDao.add(new Fruit(fruitName, 0)));
        int oldCountFruit = fruitDao.getFruitsCount(fruitName);
        fruitDao.updateFruitCount(oldCountFruit + fruitNumber, fruitName);
        return currentFruit;
    }
}
