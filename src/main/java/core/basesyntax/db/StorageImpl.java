package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private Map<Fruit, Integer> storage;

    public StorageImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public void add(Fruit fruit, Integer quantity) {
        storage.put(fruit,
                storage.get(fruit) == null ? quantity : storage.get(fruit) + quantity);
    }

    @Override
    public void remove(Fruit fruit, Integer quantity) {
        if (storage.get(fruit) < quantity) {
            throw new RuntimeException("Can't remove fruit" + fruit);
        }
        storage.put(fruit,
                storage.get(fruit) == null ? quantity : storage.get(fruit) - quantity);
    }

    @Override
    public Map<Fruit, Integer> getAllFruits() {
        return storage;
    }
}
