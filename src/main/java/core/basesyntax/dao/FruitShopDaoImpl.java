package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public void addToStorage(String key, Integer value) {
        Storage.fruits.put(key, value);
    }

    @Override
    public void addValue(String key, Integer value) {
        Integer newValue = Storage.fruits.get(key) + value;
        Storage.fruits.put(key, newValue);
    }

    @Override
    public void subtractValue(String key, Integer value) {
        Integer newValue = Storage.fruits.get(key) - value;
        Storage.fruits.put(key, newValue);
    }
}
