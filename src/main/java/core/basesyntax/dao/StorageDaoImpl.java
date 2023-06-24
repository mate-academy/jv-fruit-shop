package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    private Storage storage = new Storage();

    @Override
    public void add(String name, Integer quantity) {
        storage.fruits.put(name, quantity);
    }

    @Override
    public Integer get(String name) {
        return storage.fruits.get(name);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return storage.fruits.entrySet();
    }
}
