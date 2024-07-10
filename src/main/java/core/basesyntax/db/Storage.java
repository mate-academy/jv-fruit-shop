package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Fruit> fruits = new HashMap<>();

    public static Map<String, Fruit> getFruits() {
        return fruits;
    }
}
