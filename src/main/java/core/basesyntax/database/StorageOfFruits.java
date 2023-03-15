package core.basesyntax.database;

import java.util.HashMap;
import java.util.Map;

public class StorageOfFruits {
    private static Map<String, Integer> fruitStorage = new HashMap<>();

    public static void add(String fruit, Integer count) {
        StorageOfFruits.fruitStorage.put(fruit, count);
    }

    public static Integer get(String fruit) {
        return StorageOfFruits.fruitStorage.get(fruit);
    }

    public static Map<String, Integer> getFruits() {
        return fruitStorage;
    }
}

