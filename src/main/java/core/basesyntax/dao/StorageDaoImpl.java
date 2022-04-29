package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public void supply(Fruit fruit, int quantity) {
        Storage.storage.put(fruit, Storage.storage.get(fruit) + quantity);
    }

    @Override
    public void take(Fruit fruit, int quantity) {
        Storage.storage.put(fruit, Storage.storage.get(fruit) - quantity);
    }

    @Override
    public boolean contains(Fruit fruit) {
        return Storage.storage.containsKey(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.storage.entrySet();
    }
}
