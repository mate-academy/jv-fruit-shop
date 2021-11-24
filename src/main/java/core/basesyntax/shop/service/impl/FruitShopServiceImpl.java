package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.dao.FruitShopDao;
import core.basesyntax.shop.dao.InsufficientGoodsException;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.service.FruitShopService;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private FruitShopDao fruitShopDao;

    public FruitShopServiceImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void balance(Fruit fruit, Integer quantity) {
        fruitShopDao.add(fruit, quantity);
    }

    @Override
    public void supply(Fruit fruit, Integer quantity) {
        fruitShopDao.add(fruit, quantity);
    }

    @Override
    public void purchase(Fruit fruit, Integer quantity) {
        try {
            fruitShopDao.subtract(fruit, quantity);
        } catch (InsufficientGoodsException e) {
            throw new RuntimeException("Insufficient " + fruit.getName(), e);
        }
    }

    @Override
    public void returnBack(Fruit fruit, Integer quantity) {
        fruitShopDao.add(fruit, quantity);
    }

    @Override
    public Map<Fruit, Integer> getMap() {
        return fruitShopDao.getAll();
    }
}
