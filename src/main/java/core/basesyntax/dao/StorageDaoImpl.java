package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
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
    public void subtract(Fruit fruit, int quantity) {
        Storage.storage.put(fruit, Storage.storage.get(fruit) - quantity);
    }

    @Override
    public int getValue(Fruit fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public boolean containsKey(Fruit fruit) {
        return Storage.storage.containsKey(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.storage.entrySet();
    }
}
