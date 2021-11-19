package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private final FruitStorageDao fruitStorageDao;

    public FruitServiceImpl(FruitStorageDao fruitDao) {
        this.fruitStorageDao = fruitDao;
    }

    public void createFruit(String name) {
        Fruit fruit = new Fruit(name);
        fruitStorageDao.add(fruit);
    }
}
