package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageImpl implements Storage {
    private final Map<String, Integer> fruits = new HashMap<>();

    @Override
    public int getFruit(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    @Override
    public void setFruit(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    @Override
    public List<String> allFruits() {
        return fruits.keySet().stream().toList();
    }
}
