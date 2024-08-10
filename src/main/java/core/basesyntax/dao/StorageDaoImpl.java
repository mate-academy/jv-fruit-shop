package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    private Storage storage;

    public StorageDaoImpl() {
        storage = new Storage();
    }

    @Override
    public void add(String name, int quantity) {
        storage.add(name, quantity);
    }

    @Override
    public int get(String fruitName) {
        return storage.get(fruitName);
    }

    @Override
    public boolean contains(String fruitName) {
        return storage.contains(fruitName);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return Storage.fruits.entrySet();
    }
}
