package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitReturn implements WorkWithFruits {

    @Override
    public void workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao) {
        fruitDao.get(fruitName).orElseThrow(()
                -> new RuntimeException("You can`t return that fruit!"));
        int oldCountFruit = fruitDao.getCurrentCountFruitsInStorage(fruitName);
        fruitDao.changeFruitCountInStorage(oldCountFruit + fruitNumber, fruitName);
    }
}
