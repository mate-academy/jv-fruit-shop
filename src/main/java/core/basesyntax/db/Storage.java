package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Fruit> fruits = new HashMap<>();

    public static void addOrUpdateFruit(String name, Fruit fruit) {
        fruits.put(name, fruit);
    }

    public static Fruit getFruit(String name) {
        return fruits.get(name);
    }

    public static void removeFruit(String name) {
        fruits.remove(name);
    }

    public static int getFruitCount() {
        return fruits.size();
    }

    public static Map<String, Fruit> getFruits() {
        return new HashMap<>(fruits);
    }
}
