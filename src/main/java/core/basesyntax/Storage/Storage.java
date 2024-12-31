package core.basesyntax.Storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String,Integer> storage;

    public Storage() {
        storage = new HashMap<>();
    }
    public int getCurrentAmount(String fruitType) {
        return storage.getOrDefault(fruitType, 0);
    }

    public void put(String fruitType, int amount) {
        storage.put(fruitType,amount);
    }

    public int get(String fruitType) {
        return storage.get(fruitType);
    }

    public int getOrDefault(String fruitType, int i) {
        return storage.getOrDefault(fruitType,i);
    }
}
