package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    public static final HashMap<String, Integer> FruitStorage = new HashMap<>();

    public int get(String fruit) {
        return Storage.FruitStorage.getOrDefault(fruit, 0);
    }

    public void put (String fruit, Integer quantity) {
        Storage.FruitStorage.put(fruit, quantity);
    }
}
