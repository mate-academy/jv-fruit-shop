package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FruitShopDaoMapImpl implements FruitShopDao {
    @Override
    public void add(Fruit fruit) {
        Storage.storageMap.put(fruit.getName(), fruit);
    }

    @Override
    public Optional<Fruit> get(String name) {
        return Optional.ofNullable(Storage.storageMap.get(name));
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(Storage.storageMap.values());
    }
}
