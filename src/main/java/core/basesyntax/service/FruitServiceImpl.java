package core.basesyntax.service;

import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.Fruit;

public class FruitServiceImpl implements FruitService {
    private FruitShopDaoImpl fruitShopDao;

    public FruitServiceImpl(FruitShopDaoImpl fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void addNewFruit(Fruit.TYPE type, Integer value, Fruit.ACTIVITY activity) {
        Fruit fruit = new Fruit();
        fruit.setType(type);
        fruit.setValue(value);
        fruit.setActivity(activity);
        fruitShopDao.add(fruit);
    }
}
