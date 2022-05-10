package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Fruit, Integer> fruits = new HashMap<>();

    public static Map<Fruit, Integer> getFruits() {
        return fruits;
    }

    public static void setFruits(Fruit fruit, int amount) {
        fruits.put(fruit, amount);
    }
}
