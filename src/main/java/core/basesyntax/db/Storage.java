package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private final Map<Fruit, Integer> fruits;

    public Storage() {
        fruits = new TreeMap<>();
    }

    public Map<Fruit, Integer> getFruits() {
        return fruits;
    }
}
