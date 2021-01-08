package core.basesyntax.database;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static Map<Fruit, Integer> fruitsMap = new TreeMap<>();

    public static Map<Fruit, Integer> getFruitsMap() {
        return fruitsMap;
    }

    public static void setFruitsMap(Map<Fruit, Integer> fruitData) {
        Storage.fruitsMap = fruitData;
    }
}
