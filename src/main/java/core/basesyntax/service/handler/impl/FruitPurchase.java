package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitPurchase implements WorkWithFruits {
    @Override
    public void workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao) {
        fruitDao.get(fruitName).orElseThrow(()
                -> new RuntimeException("You really thought I had this fruit?"));
        int oldCountFruit = fruitDao.getCurrentCountFruitsInStorage(fruitName);
        if (oldCountFruit < fruitNumber) {
            throw new RuntimeException("Not enough fruits in storage");
        } else {
            fruitDao.changeFruitCountInStorage(oldCountFruit - fruitNumber, fruitName);
        }
    }
}
