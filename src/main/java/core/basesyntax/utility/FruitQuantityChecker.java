package core.basesyntax.utility;

import java.util.Map;

public class FruitQuantityChecker {
    public void checkFruitQuantity(Map<String, Integer> fruitMap) {
        for (Integer temp : fruitMap.values()) {
            if (temp < 0) {
                throw new RuntimeException(" Fruit quantity must be positive number");
            }
        }
    }
}
