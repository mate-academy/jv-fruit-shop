package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitDB {
    private static final Map<String, Integer> fruitDataBase = new HashMap<>();

    public static Map<String, Integer> getFruitDataBase() {
        return fruitDataBase;
    }
}
