package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> fruits = new HashMap<>();

    public static void applyToStorage(Fruit fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public static Integer getQuantity(Fruit fruit) {
        return fruits.get(fruit);
    }

    public static Map<Fruit, Integer> getAll() {
        Map<Fruit, Integer> fruitsCopy = new HashMap<>();
        for (Map.Entry<Fruit, Integer> fruitEntry : fruits.entrySet()) {
            fruitsCopy.put(fruitEntry.getKey().clone(), fruitEntry.getValue());
        }
        return fruitsCopy;
    }
}
