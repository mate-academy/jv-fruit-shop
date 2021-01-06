package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static Map<Fruit, Integer> fruits = new TreeMap<>();

    public static void setFruits(Map<Fruit, Integer> fruits) {
        Storage.fruits = fruits;
    }

    public static Map<Fruit, Integer> getFruits() {
        return fruits;
    }
}
