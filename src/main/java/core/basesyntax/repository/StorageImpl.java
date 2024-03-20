package core.basesyntax.repository;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private final Map<String, Integer> fruitsQuantity = new HashMap<>();

    @Override
    public void add(String fruitName, Integer value) {
        fruitsQuantity.put(fruitName, value);
    }

    @Override
    public Integer getQuantity(String fruitName) {
        return fruitsQuantity.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return fruitsQuantity;
    }
}
