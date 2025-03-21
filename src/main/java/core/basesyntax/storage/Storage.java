package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static void putFruit(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public static int getQuantity(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public static boolean containsFruit(String fruit) {
        return fruitStorage.containsKey(fruit);
    }

    public static Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruitStorage);
    }

    public static void clearStorage() {
        fruitStorage.clear();
    }

}
