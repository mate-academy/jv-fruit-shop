package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitMapImpl implements FruitMap {
    public static final Map<String, Integer> fruitMap = new HashMap<>();

    @Override
    public void put(String fruit, int quantity) {
        fruitMap.put(fruit, quantity);
    }

    @Override
    public int get(String fruit) {
        return fruitMap.get(fruit);
    }
}
