package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static final Map<String, Integer> fruitRepository = new HashMap<>();

    public static Map<String, Integer> getFruits() {
        return fruitRepository;
    }
}
