package core.basesyntax.storage;

import core.basesyntax.exceptions.FruitsNameException;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruits = new HashMap<>();

    public static void createMap() {
        fruits = new HashMap<>();
    }

    public static void clear() {
        fruits.clear();
    }

    public static Map<String, Integer> getStorage() {
        return fruits;
    }

    public static int getFruits(String fruit) {
        return Storage.fruits.getOrDefault(fruit, 0);
    }

    public static void addFruits(String fruit, int quantity) {
        validateData(fruit,quantity);
        Storage.fruits.put(fruit, quantity);
    }

    public static void validateData(String fruit, int quantity) {
        if (fruit == null || fruit.isEmpty()) {
            throw new FruitsNameException("Wrong fruit name: "
                    + fruit);
        }
        if (quantity < 0) {
            throw new RuntimeException("Wrong fruit quantity for "
                    + fruit
                    + ", quantity: "
                    + quantity);
        }
    }
}
