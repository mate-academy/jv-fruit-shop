package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private StorageDao storageDao;

    public FruitServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void createNewFruit(String type, int amount) {
       Fruit fruit = new Fruit();
       fruit.setFruitType(type);
       fruit.setAmount(amount);
       storageDao.add(fruit);
    }
}
