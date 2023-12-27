package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapFruitDB implements FruitDB {
    private final Map<String, Integer> map = new HashMap<>();

    @Override
    public int getQuantity(String fruit) {
        return map.getOrDefault(fruit, 0);
    }

    @Override
    public void setQuantity(String fruit, int quantity) {
        map.put(fruit, quantity);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return map.entrySet();
    }
}
