package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(String fruitName, int quantity) {
        Storage.fruitStorage.put(fruitName,quantity);
    }

    @Override
    public int get(String key) {
        return Storage.fruitStorage.get(key);
    }

    @Override
    public Map<String, Integer> getStorageState() {
        return Storage.fruitStorage;
    }
}
