package core.basesyntax.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final HashMap<String, Integer> fruitStatus = new HashMap<>();

    public static void setFruitQuantity(String fruitName, int quantity) {
        fruitStatus.put(fruitName, quantity);
    }

    public static void addFruitQuantity(String fruitName, int quantity) {
        int currentQuantity = fruitStatus.getOrDefault(fruitName, 0);
        fruitStatus.put(fruitName, currentQuantity + quantity);
    }

    public static void substractFruitQuantity(String fruitName, int quantity) {
        int currentQuantity = fruitStatus.getOrDefault(fruitName, 0);
        fruitStatus.put(fruitName, currentQuantity - quantity);
    }

    public static int getFruitQuantity(String fruitName) {
        return fruitStatus.getOrDefault(fruitName, 0);
    }

    public static Collection<Map.Entry<String, Integer>> getFullStorage() {
        return fruitStatus.entrySet();
    }
}
