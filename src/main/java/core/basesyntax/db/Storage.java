package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static Map<Fruit, Integer> fruits;

    public Storage() {
        fruits = new TreeMap<>();
    }

    public static Map<Fruit, Integer> getFruits() {
        return fruits;
    }
}
