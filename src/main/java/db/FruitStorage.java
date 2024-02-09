package db;

import java.util.Map;
import java.util.TreeMap;

public class FruitStorage {
    private static Map<String, Integer> fruits = new TreeMap<>();

    public Map<String, Integer> getFruits() {
        return fruits;
    }
}
