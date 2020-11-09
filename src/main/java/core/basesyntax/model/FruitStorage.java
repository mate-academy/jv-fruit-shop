package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static Map<String, FruitDateAmountPair> fruitStorage = new HashMap<>();

    public static Map<String, FruitDateAmountPair> getFruitStorage() {
        return fruitStorage;
    }
}
