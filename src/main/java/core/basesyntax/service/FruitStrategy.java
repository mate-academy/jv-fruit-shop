package core.basesyntax.service;

import java.util.Map;

public interface FruitStrategy {
    void applyToStorage(Map<String, Integer> fruitQuantityMap,
                        String operation, String fruitName, int quantity);
}
