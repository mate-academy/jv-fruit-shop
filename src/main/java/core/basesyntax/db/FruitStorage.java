package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static Map<String, Integer> fruitStorage = new HashMap<>();

    public static Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
