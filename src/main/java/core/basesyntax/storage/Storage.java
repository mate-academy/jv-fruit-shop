package core.basesyntax.storage;

import core.basesyntax.exceptions.FruitsNameException;
import core.basesyntax.exceptions.FruitsQuantityException;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruits;

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
        if (fruit == null || fruit.isEmpty()) {
            throw new FruitsNameException("Wrong fruit name: "
                    + fruit);
        }
        if (quantity < 0) {
            throw new FruitsQuantityException("Wrong fruit quantity for "
                    + fruit
                    + ", quantity: "
                    + quantity);
        }
        Storage.fruits.put(fruit, quantity);
    }
}
