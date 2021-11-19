package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private final FruitStorageDao fruitStorageDao;

    public FruitServiceImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    public void createFruit(String fruitType) {
        Fruit fruit = new Fruit(fruitType);
        fruitStorageDao.add(fruit);
    }
}
