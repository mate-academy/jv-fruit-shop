package core.basesyntax.storage;

import core.basesyntax.exception.FruitShopException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage = new LinkedHashMap<>();

    public void put(String fruit, int quantity) {
        validateFruit(fruit);
        if (quantity < 0) {
            throw new FruitShopException("Quantity must be >= 0");
        }
        storage.put(fruit, quantity);
    }

    public int get(String fruit) {
        validateFruit(fruit);
        return storage.getOrDefault(fruit, 0);
    }

    public void increase(String fruit, int amount) {
        validateFruit(fruit);
        if (amount < 0) {
            throw new FruitShopException("Amount to increase must be >= 0");
        }
        storage.put(fruit, get(fruit) + amount);
    }

    public void decrease(String fruit, int amount) {
        validateFruit(fruit);
        if (amount < 0) {
            throw new FruitShopException("Amount to decrease must be >= 0");
        }
        storage.put(fruit, get(fruit) - amount);
    }

    public Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(storage);
    }

    private void validateFruit(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new FruitShopException("Fruit name is null or blank");
        }
    }
}
