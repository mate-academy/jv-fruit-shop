package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    private final Map<String, Integer> fruitStorage = new HashMap<>();

    @Override
    public void put(String fruitName, int fruitQuantity) {
        fruitStorage.put(fruitName, fruitQuantity);
    }

    @Override
    public Integer getQuantity(String fruitName) {
        return fruitStorage.get(fruitName);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getSet() {
        return fruitStorage.entrySet();
    }
}
