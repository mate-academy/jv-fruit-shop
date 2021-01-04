package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void addNewFruit(String fruitName, int amount) {
        Fruit fruit = new Fruit();
        fruit.setFruitName(fruitName);
        fruit.setAmount(amount);
        fruitDao.add(fruit);
    }
}
