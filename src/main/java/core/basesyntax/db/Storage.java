package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.exceptions.InvalidFruitException;
import core.basesyntax.service.exceptions.InvalidQuantityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    private static final Map<Fruit, Integer> fruits = new HashMap<>();

    public static Integer getQuantity(Fruit fruit) {
        if (fruits.get(fruit) != null) {
            return fruits.get(fruit);
        }
        throw new InvalidQuantityException("Not found quantity value for fruit: " + fruit);
    }

    public static void put(Fruit fruit, Integer quantity) {
        if (fruit == null) {
            throw new InvalidFruitException("Fruit can't be null");
        }
        if (quantity == null || quantity < 0) {
            throw new InvalidQuantityException("Quantity must be positive number");
        }
        fruits.put(fruit, quantity);
    }

    public static Set<Fruit> keyset() {
        return Set.copyOf(fruits.keySet());
    }

    public static boolean containsKey(Fruit key) {
        return fruits.containsKey(key);
    }

}
