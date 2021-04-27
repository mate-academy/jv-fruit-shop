package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static Map<String, Fruit> fruitStorage = new HashMap<>();

    public static Map<String, Fruit> getFruitStorage() {
        return fruitStorage;
    }
}
