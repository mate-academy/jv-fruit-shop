package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;

public class StorageServiceAddImpl implements StorageService {
    private FruitDao fruitDao;

    public StorageServiceAddImpl(FruitDaoImpl fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operateSupply(String forFruit, Integer quantity) {
        Fruit fruit = new Fruit();
        fruit.setNameFruit(forFruit);
        fruit.setQuantityFruit(quantity);
        fruitDao.add(fruit);
    }
}
