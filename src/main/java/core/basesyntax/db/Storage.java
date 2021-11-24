package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Fruit, Integer> storage = new HashMap<>();

    public static Map<Fruit, Integer> getStorage() {
        return storage;
    }

    public static void setFruit(Fruit fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }
    
    public static void add(Fruit fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }
}
