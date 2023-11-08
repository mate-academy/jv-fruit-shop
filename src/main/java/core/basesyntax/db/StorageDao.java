package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StorageDao {
    public static final Map<String, Integer> FRUIT_KINDS_AND_QUANTITY = new HashMap<>();

    public static void addFruit(String fruit, int quantity) {
        FRUIT_KINDS_AND_QUANTITY.put(fruit, quantity);
    }

    public static int getFruitQuantity(String fruit) {
        return FRUIT_KINDS_AND_QUANTITY.getOrDefault(fruit, 0);
    }

    public static Set<Map.Entry<String, Integer>> getFruitEntries() {
        return FRUIT_KINDS_AND_QUANTITY.entrySet();
    }
}
