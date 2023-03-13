package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    private static final Map<String, Integer> storage = new HashMap<>();

    @Override
    public void put(String fruit, int amount) {
        storage.put(fruit, amount);
    }

    @Override
    public int get(String fruit) {
        return storage.get(fruit);
    }

    @Override
    public boolean isContains(String fruit) {
        return storage.containsKey(fruit);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return storage.entrySet();
    }
}
