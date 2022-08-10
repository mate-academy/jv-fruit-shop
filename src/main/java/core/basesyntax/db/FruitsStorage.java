package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitsStorage {
    private static Map<String, Integer> fruits = new HashMap<>();

    public static Map<String, Integer> getFruits() {
        return fruits;
    }
}
