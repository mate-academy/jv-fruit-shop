package core.basesyntax.db;

import java.util.LinkedHashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private static final int ZERO = 0;
    private final Map<String, Integer> map;

    public StorageImpl(Map<String, Integer> map) {
        if (map == null) {
            throw new RuntimeException("Map must not be null");
        }
        this.map = new LinkedHashMap<>(map);
    }

    @Override
    public int getFruit(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit name must be non-null and non-blank");
        }
        return map.getOrDefault(fruit, ZERO);
    }

    @Override
    public void add(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit name must be non-null and non-blank");
        }
        if (quantity < ZERO) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
        int newValue = getFruit(fruit) + quantity;
        map.put(fruit, newValue);
    }

    @Override
    public void set(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit name must be non-null and non-blank");
        }
        if (quantity < ZERO) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
        map.put(fruit, quantity);
    }

    @Override
    public void delete(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit name must be non-null and non-blank");
        }
        if (quantity < ZERO) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
        int findFruit = getFruit(fruit);
        if (quantity > findFruit) {
            throw new RuntimeException("Insufficient stock for '"
                    +
                    fruit + "': requested=" + quantity + ", available=" + findFruit);
        }
        int value = findFruit - quantity;
        map.put(fruit, value);
    }

    public Map<String, Integer> getSnapshot() {
        return new LinkedHashMap<>(map);
    }
}
