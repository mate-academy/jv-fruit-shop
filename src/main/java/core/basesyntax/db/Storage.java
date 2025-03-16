package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String,Integer> fruits = new HashMap<>();

    public static void addFruit(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public static void removeFruit(String fruit, int quantity) {
        if (!fruits.containsKey(fruit) || fruits.get(fruit) < quantity) {
            throw new IllegalArgumentException("Недостатньо " + fruit + "в наявності");
        }
        fruits.put(fruit, fruits.get(fruit) - quantity);
    }

    public static String getFruits() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            sb.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
