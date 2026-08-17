package core.basesyntax.db;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Storage implements FruitStorage {
    private final Map<String, Integer> fruits = new LinkedHashMap<>();

    @Override
    public int getQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    @Override
    public void setQuantity(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(fruits);
    }

}
