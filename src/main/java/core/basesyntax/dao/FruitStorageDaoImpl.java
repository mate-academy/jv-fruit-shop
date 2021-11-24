package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(String name, int quantity) {
        Storage.fruitStorage.putIfAbsent(name, quantity);
    }

    @Override
    public int getValue(String name) {
        return Storage.fruitStorage.get(name);
    }

    @Override
    public boolean containsKey(String name) {
        return Storage.fruitStorage.containsKey(name);
    }

    @Override
    public void update(String name, int quantity) {
        Storage.fruitStorage.put(name, Storage.fruitStorage.get(name) + quantity);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return Storage.fruitStorage.entrySet();
    }
}
