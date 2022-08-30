package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Fruit, Integer> fruitsMap = new HashMap<>();

    public static Map<Fruit, Integer> getFruitsMap() {
        return fruitsMap;
    }
}
