package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitQuantity = new HashMap<>();

    public static Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruitQuantity);
    }

    public static Integer getFruitQuantity(String fruit) {
        return fruitQuantity.get(fruit);
    }

    public static void setFruitQuantity(String fruit, Integer quantity) {
        fruitQuantity.put(fruit, quantity);
    }
}
