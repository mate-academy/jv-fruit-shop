package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitPurchase implements WorkWithFruits {
    @Override
    public Fruit workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao) {
        Fruit currentFruit = fruitDao.get(fruitName).orElseThrow(()
                -> new RuntimeException("You really thought I had this fruit?"));
        int oldCountFruit = fruitDao.getFruitsCount(fruitName);
        if (oldCountFruit < fruitNumber) {
            throw new RuntimeException("Not enough fruits in storage");
        } else {
            fruitDao.updateFruitCount(oldCountFruit - fruitNumber, fruitName);
        }
        return currentFruit;
    }
}
