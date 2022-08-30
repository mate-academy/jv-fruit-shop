package core.basesyntax.storage;

import core.basesyntax.model.Fruit;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<Fruit, Integer> storage = new HashMap<>();

    public static void put(Fruit fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }

    public static Integer get(Fruit fruit) {
        return storage.get(fruit);
    }

    public static Map<Fruit, Integer> getStorage() {
        return storage;
    }
}