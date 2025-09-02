package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final int MIN_QUANTITY = 0;
    private static final Map<String,Integer> fruits = new HashMap<>();

    public static void add(String fruit, int quantity) {
        if (quantity >= MIN_QUANTITY) {
            fruits.put(fruit,quantity);
        } else {
            throw new RuntimeException("The quantity can't be less than 0!");
        }
    }

    public static int getQuantity(String fruit) {
        return fruits.getOrDefault(fruit, MIN_QUANTITY);
    }

    public static Map<String, Integer> getAllItems() {
        return fruits;
    }
}
