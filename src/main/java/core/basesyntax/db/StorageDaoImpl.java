package core.basesyntax.db;

import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruitName, int quantity) {
        if (fruitName == null) {
            throw new RuntimeException("FruitName must be not null");
        }
        Storage.fruits.put(fruitName, quantity);
    }

    @Override
    public Integer get(String fruitName) {
        for (var mapEntry: Storage.fruits.entrySet()) {
            if (mapEntry.getKey().equals(fruitName)) {
                return mapEntry.getValue();
            }
        }
        throw new RuntimeException("Storage don't contain " + fruitName);
    }

    @Override
    public Set<Map.Entry<String,Integer>> getAll() {
        return Storage.fruits.entrySet();
    }
}
