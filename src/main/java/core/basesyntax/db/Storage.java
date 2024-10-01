package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> fruitInventory = new HashMap<>();

    public static int getFruitQuiantity(Fruit fruit) {
        return fruitInventory.getOrDefault(fruit,0);
    }

    public static void updateFruitQuantity(Fruit fruit, int quantity) {
        fruitInventory.put(fruit,quantity);
    }

    public static Map<Fruit, Integer> getInventory() {
        return new HashMap<>(fruitInventory);
    }

    public static void clear() {
        fruitInventory.clear();
    }
}
