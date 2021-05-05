package core.basesyntax.db;

import core.basesyntax.shop.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<Fruit, Integer> fruits = new HashMap<>();

    public static Map<Fruit, Integer> getFruits() {
        return fruits;
    }
}
