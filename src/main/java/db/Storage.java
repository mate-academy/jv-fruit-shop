package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitsStock = new HashMap<>();

    public static void updateDb(String name, Integer quantity) {
        fruitsStock.put(name, quantity);
    }

    public static Map<String, Integer> readDb(){
        return new HashMap<>(fruitsStock);
    }

    public static Integer getQuantity(String fruitName) {
        return fruitsStock.get(fruitName);
    }
}
