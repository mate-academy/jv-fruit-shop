package core.basesyntax.dao.storage.impl;

import core.basesyntax.dao.storage.FruitStorageDao;
import core.basesyntax.db.Storage;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;

public class FruitStorageDaoImpl implements FruitStorageDao {
    private final Storage storage;

    public FruitStorageDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(storage.getStorageMap());
    }

    @Override
    public int getFruitQuantity(String key) {
        return storage.getStorageMap().get(key);
    }

    @Override
    public int addFruitQuantity(String key, int value) {
        storage.getStorageMap().put(key, value);
        return value;
    }

    @Override
    public int merge(String key, int value,
                     BiFunction<Integer, Integer, Integer> remappingFunction) {
        return storage.getStorageMap().merge(key, value, remappingFunction);
    }

    @Override
    public boolean isFruitInStorage(String fruitName) {
        return storage.getStorageMap().containsKey(fruitName);
    }

    @Override
    public boolean hasSufficientFruitQuantity(String fruit, int quantity) {
        return getFruitQuantity(fruit) >= quantity;
    }
}
