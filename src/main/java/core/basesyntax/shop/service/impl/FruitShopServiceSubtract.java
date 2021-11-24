package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.dao.FruitShopDao;
import core.basesyntax.shop.dao.FruitShopDaoImpl;
import core.basesyntax.shop.dao.InsufficientGoodsException;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.service.FruitShopService;

public class FruitShopServiceSubtract implements FruitShopService {
    private FruitShopDao fruitShopDao;

    public FruitShopServiceSubtract() {
        this.fruitShopDao = new FruitShopDaoImpl();
    }

    @Override
    public boolean apply(Fruit fruit, Integer quantity) {
        try {
            fruitShopDao.subtract(fruit, quantity);
        } catch (InsufficientGoodsException e) {
            throw new RuntimeException("Insufficient " + fruit.getName(), e);
        }
        return true;
    }
}
