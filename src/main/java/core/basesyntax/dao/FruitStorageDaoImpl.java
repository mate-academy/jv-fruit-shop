package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void updateFruitQuantity(String fruit, Integer quantity) {
        FruitStorage.FRUIT_STORAGE.put(fruit, quantity);
    }

    @Override
    public Integer getFruitQuantity(String fruit) {
        return FruitStorage.FRUIT_STORAGE.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAllFruit() {
        return FruitStorage.FRUIT_STORAGE;
    }
}
