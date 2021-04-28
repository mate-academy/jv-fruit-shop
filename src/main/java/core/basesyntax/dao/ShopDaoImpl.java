package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.shop.Fruit;

public class ShopDaoImpl implements ShopDao {
    @Override
    public boolean add(Fruit fruits, int count) {
        Storage.getFruits().put(fruits,count);
        return true;
    }

    @Override
    public int get(Fruit fruit) {
        return Storage.getFruits().getOrDefault(fruit,0);
    }
}
