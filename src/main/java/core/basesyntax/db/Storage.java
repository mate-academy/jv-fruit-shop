package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitStorage = new HashMap<>();

    public static Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }

    public static void setFruitStorage(Map<String,Integer> fruitStorage) {
        Storage.fruitStorage = fruitStorage;
    }
}
