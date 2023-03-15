package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static void putOrChange(String fruitName, int quantity) {
        if (fruits.containsKey(fruitName)) {
            quantity += fruits.get(fruitName);
        }
        fruits.put(fruitName, quantity);
    }
}
