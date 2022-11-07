package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addFruit(String key, Integer value) {
        Storage.fruitStorage.put(key, value);
    }

    @Override
    public Integer getFruitBalance(String key) {
        return Storage.fruitStorage.get(key);
    }

    @Override
    public void update(String key, int value) {
        Storage.fruitStorage.replace(key, value);
    }

    @Override
    public Map<String, Integer> getFruitStorage() {
        return Storage.fruitStorage;
    }
}
