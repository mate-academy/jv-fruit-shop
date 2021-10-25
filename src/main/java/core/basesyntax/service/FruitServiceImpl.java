package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void createNewFruit(String fruitName, int quantity) {
        Fruit fruit = new Fruit.FruitBuilder().setName(fruitName).setQuantity(quantity).build();
        fruitDao.add(fruitName);
    }
}
