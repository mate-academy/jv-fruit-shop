package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage storage;
    private Map<String, Integer> fruitStorage = new HashMap<>();

    private Storage() {
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }

    public void setFruitStorage(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }
}
