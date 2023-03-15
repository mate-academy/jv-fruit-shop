package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(String fruit, Integer value) {
        Storage.fruits.put(fruit, value);
    }

    @Override
    public int get(String fruit) {
        return Storage.fruits.get(fruit);
    }
}
