package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private FruitsDao fruitsDao;

    public FruitServiceImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void createFruit(String fruitName, int fruitQuantity) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        fruit.setQuantity(fruitQuantity);
        fruitsDao.add(fruit);
    }
}
