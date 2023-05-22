package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    public static final HashMap<String, Integer> fruitStorage = new HashMap<>();

    public int get(String fruit) {
        return Storage.fruitStorage.getOrDefault(fruit, 0);
    }

    public void put(String fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }
}
