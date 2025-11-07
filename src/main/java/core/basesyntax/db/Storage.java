package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static void setQuantity(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public static void addQuantity(String fruit, int quantity) {
        fruitStorage.merge(fruit, quantity, Integer::sum);
    }

    public static int getQuantity(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(fruitStorage);
    }
}
