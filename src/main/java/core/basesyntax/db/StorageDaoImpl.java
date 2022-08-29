package core.basesyntax.db;

import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private final Storage storage;

    public StorageDaoImpl() {
        storage = new Storage();
    }

    @Override
    public void add(String fruit, int amount) {
        storage.getFruitsAmount().put(fruit, amount);
    }

    @Override
    public void supply(String fruit, int amount) {
        storage.getFruitsAmount().put(fruit, storage.getFruitsAmount().get(fruit) + amount);
    }

    @Override
    public void remove(String fruit, int amount) {
        storage.getFruitsAmount().put(fruit, storage.getFruitsAmount().get(fruit) - amount);
    }

    @Override
    public Map<String, Integer> getFruitsAmount() {
        return storage.getFruitsAmount();
    }
}
