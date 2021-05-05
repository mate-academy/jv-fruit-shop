package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Optional;

public class FruitShopDaoMapImpl implements FruitShopDao {
    @Override
    public void add(Fruit fruit, int quantity) {
        Storage.storageMap.put(fruit, quantity);
    }

    public int getBalance(Fruit fruit) {
        return Storage.storageMap.getOrDefault(fruit, 0);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.storageMap;
    }
}
