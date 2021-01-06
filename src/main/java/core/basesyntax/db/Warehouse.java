package core.basesyntax.db;

import core.basesyntax.model.entities.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Map<Fruit, Integer> FRUIT_STORAGE = new HashMap<>();

    public static Map<Fruit, Integer> getFruitStorage() {
        return FRUIT_STORAGE;
    }
}
