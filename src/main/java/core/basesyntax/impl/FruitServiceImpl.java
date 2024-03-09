package core.basesyntax.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void createNewFruit(String fruitName) {
        Fruit fruit = new Fruit();
        fruit.setFruit(fruitName);
        fruitDao.add(fruit);
    }
}
