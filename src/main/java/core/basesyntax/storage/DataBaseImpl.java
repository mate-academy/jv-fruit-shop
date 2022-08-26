package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class DataBaseImpl implements DataBase {
    private HashMap<String, Integer> storage;

    public DataBaseImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public void add(String fruit, Integer quantity) {
        storage.put(fruit, storage.get(fruit) == null ? quantity :
                storage.get(fruit) + quantity);
    }

    @Override
    public void remove(String fruit, Integer quantity) {
        if (storage.get(fruit) < quantity) {
            throw new RuntimeException("Can't remove fruit from storage.");
        }
        storage.put(fruit, storage.get(fruit) == null ? quantity :
                storage.get(fruit) - quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage;
    }
}
