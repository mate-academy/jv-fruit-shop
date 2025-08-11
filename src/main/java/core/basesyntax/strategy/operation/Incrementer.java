package core.basesyntax.strategy.operation;

import java.util.Map;

public class Incrementer {

    public static void add(Map<String, Integer> storage, String fruit, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Quantity to add cannot be negative: " + quantity
            );
        }
        int current = storage.getOrDefault(fruit, 0);
        storage.put(fruit, current + quantity);
    }
}
