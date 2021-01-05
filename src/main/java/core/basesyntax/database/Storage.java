package core.basesyntax.database;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static Map<Fruit, Integer> fruitData = new TreeMap<>();

    public static void setFruitData(Map<Fruit, Integer> fruitData) {
        Storage.fruitData = fruitData;
    }

    public static Map<Fruit, Integer> getFruitData() {
        return fruitData;
    }
}
