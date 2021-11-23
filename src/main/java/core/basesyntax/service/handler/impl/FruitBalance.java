package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitBalance implements WorkWithFruits {
    @Override
    public void workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao) {
        Fruit newFruit = new Fruit(fruitName, fruitNumber);
        fruitDao.get(fruitName).ifPresentOrElse(
                f -> {
                    throw new RuntimeException("Fruit name should be individual. Fruit name: "
                            + fruitName);
                },
                () -> fruitDao.add(newFruit));
    }
}
