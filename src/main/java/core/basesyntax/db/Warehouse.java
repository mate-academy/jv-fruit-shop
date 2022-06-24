package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Map<Fruit, Integer> warehouse = new HashMap<>();

    public static Map<Fruit, Integer> getWarehouse() {
        return warehouse;
    }
}
