package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    public static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static void put(String fruit, Integer quantity) {
        fruitStorage.put(fruit, quantity);
    }
}
