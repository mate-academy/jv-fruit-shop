package core.basesyntax.utility;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitQuantityChecker {
    public void checkFruitQuantity(Map<String, Fruit> fruitMap) {
        for (Fruit temp : fruitMap.values()) {
            if (temp.getQuantity() < 0) {
                throw new RuntimeException(" Fruit quantity must be positive number");
            }
        }
    }
}
