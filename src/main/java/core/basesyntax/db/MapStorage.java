package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class MapStorage implements Storage {
    private final Map<String, Integer> fruitsMap;

    public MapStorage() {
        this.fruitsMap = new HashMap<>();
    }

    @Override
    public void add(String fruit, Integer quantity) {
        fruitsMap.put(fruit, quantity);
    }

    @Override
    public Integer getQuantityByFruit(String fruit) {
        return fruitsMap.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return fruitsMap;
    }
}
