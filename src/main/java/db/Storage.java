package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Storage INSTANCE = new Storage();
    private final Map<String, Integer> fruitStorage = new HashMap<>();

    public Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }

    public static Storage getInstance() {
        return INSTANCE;
    }
}
