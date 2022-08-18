package core.storage;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private Map<String, Integer> storage;

    public StorageImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public void add(String fruit, Integer quantity) {
        storage.put(fruit,
                (storage.get(fruit) == null ? quantity : storage.get(fruit) + quantity));
    }

    @Override
    public void remove(String fruit, Integer quantity) {
        if (storage.get(fruit) < quantity) {
            throw new RuntimeException("Can`t remove fruit from storage. Params: Fruit = " + fruit
                    + " quantity = " + quantity + " amount = " + storage.get(fruit));
        }
        storage.put(fruit,
                (storage.get(fruit) == null ? quantity : storage.get(fruit) - quantity));
    }

    @Override
    public Map<String, Integer> getAllData() {
        return storage;
    }
}
