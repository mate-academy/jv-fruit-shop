package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String name, int quantity) {
        Storage.fruits.put(name, quantity);
    }

    @Override
    public int get(String fruitName) {
        return Storage.fruits.get(fruitName);
    }

    @Override
    public boolean contains(String fruitName) {
        return Storage.fruits.containsKey(fruitName);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return Storage.fruits.entrySet();
    }
}
