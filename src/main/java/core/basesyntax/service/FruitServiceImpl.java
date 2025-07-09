package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit createNewFruit(String fruitName) {
        Fruit fruit = new Fruit(fruitName);
        fruitDao.add(fruit);
        return fruit;
    }
}
