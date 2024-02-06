package core.basesyntax.dao;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;

import java.util.Map;

public class FruitStorageDaoImpL implements FruitStorageDao {
    @Override
    public void addFruitToStorage(Fruit fruit, Integer amount) {
        FruitsStorage.storage.put(fruit, amount);
    }

    @Override
    public Integer getFruitQuantityInStorage(Fruit fruit) {
        return FruitsStorage.storage.getOrDefault(fruit, 0);
    }

    @Override
    public Map<Fruit, Integer> getAllFromStorage() {
        return FruitsStorage.storage;
    }
}
