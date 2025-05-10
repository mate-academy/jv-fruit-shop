package core.basesyntax.storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static Map<String, Integer> getFruitStorage() {
        return Collections.unmodifiableMap(fruitStorage);
    }

    public static void addFruit(String fruit, int quantity) {
        fruitStorage.merge(fruit, quantity, Integer::sum);
    }

    public static void setFruitQuantity(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public static int getFruitQuantity(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }
}
