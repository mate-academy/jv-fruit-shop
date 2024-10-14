package database;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> assortment = new HashMap<>();

    public static Map<String, Integer> getAssortment() {
        return Map.copyOf(assortment);
    }

    public static void updateStorage(Map<String, Integer> transactions) {
        assortment.putAll(transactions);
    }
}
