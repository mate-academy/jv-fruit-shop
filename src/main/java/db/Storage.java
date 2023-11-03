package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> storageMap = new HashMap<>();

    public static void addFruit(String fruit, Integer amount) {
        storageMap.put(fruit, amount + storageMap.get(fruit));
    }

    public static Map<String, Integer> getFruitsAndAmount() {
        Map<String, Integer> newMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : storageMap.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }

        return newMap;
    }

    public static void setAmount(String fruit, Integer number) {
        storageMap.put(fruit, number);
    }
}
