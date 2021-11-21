package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitPurchase implements WorkWithFruits {
    @Override
    public void workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao) {
        int oldCountFruit = fruitDao.getCurrentCountFruitsInStorage(fruitName);
        if (oldCountFruit < fruitNumber) {
            throw new RuntimeException("Not enough fruits in storage");
        } else {
            fruitDao.changeFruitCountInStorage(oldCountFruit - fruitNumber, fruitName);
        }
    }
}
