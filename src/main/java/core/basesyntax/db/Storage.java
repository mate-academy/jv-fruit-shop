package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Fruit> fruits = new HashMap<>();

    public static Fruit getFruit(String name) {
        return fruits.get(name);
    }

    public static void addOrUpdateFruit(String name, Fruit fruit) {
        fruits.put(name, fruit);
    }

    public static Map<String, Fruit> getAllFruits() {
        return new HashMap<>(fruits);
    }
}
