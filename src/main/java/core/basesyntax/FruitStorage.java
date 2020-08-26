package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    static Map<FruitBatch, Integer> fruits = new HashMap<FruitBatch, Integer>();

    public static Map<FruitBatch, Integer> getFruits() {
        return fruits;
    }

    public static void clearStock() {
        fruits.clear();
    }
}
