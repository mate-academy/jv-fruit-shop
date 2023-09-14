package core.basesyntax.utility;

import java.util.Map;

public class FruitQuantityChecker {
    public void checkFruitQuantity(Map<String, Integer> fruitMap) {
        for (Integer quantity : fruitMap.values()) {
            if (quantity == null) {
                throw new RuntimeException("Quantity must not be null");
            }
            if (quantity < 0) {
                throw new RuntimeException("Fruit quantity must be positive number, "
                      + "but was " + quantity);
            }
        }
    }
}
