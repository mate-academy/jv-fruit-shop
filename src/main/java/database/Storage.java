package database;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> assortment = new HashMap<>();

    public static Map<String, Integer> getAssortment() {
        return Map.copyOf(assortment);
    }

    public static void updateStorage(String fruit, int quantity) {
        int finalQuantity = assortment.containsKey(fruit)
                ? assortment.get(fruit) + quantity : quantity;
        assortment.put(fruit, finalQuantity);
    }
}
