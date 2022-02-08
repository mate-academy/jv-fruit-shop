package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.dao.FruitShopDao;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.service.FruitShopService;

public class FruitShopServiceAdd implements FruitShopService {
    private FruitShopDao fruitShopDao;

    public FruitShopServiceAdd(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public boolean apply(Fruit fruit, Integer quantity) {
        fruitShopDao.add(fruit, quantity);
        return true;
    }
}
