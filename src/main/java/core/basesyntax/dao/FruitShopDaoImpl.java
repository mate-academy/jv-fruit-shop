package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Optional;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(Fruit fruit, int quantity) {
        Storage.storageMap.put(fruit, quantity);
    }

    public int getBalance(Fruit fruit) {
        return Optional.ofNullable(Storage.storageMap.get(fruit)).orElse(0);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.storageMap;
    }
}
