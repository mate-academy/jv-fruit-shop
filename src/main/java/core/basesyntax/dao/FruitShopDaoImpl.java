package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void put(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public Integer get(String fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }
}
