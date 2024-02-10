package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.Strategy;
import java.util.Map;

public class PurchaseService implements Strategy {
    @Override
    public void processData(Map<String, Integer> fruitData, String fruit, int quantity) {
        int currentQuantity = fruitData.getOrDefault(fruit, 0);
        if (currentQuantity >= quantity) {
            fruitData.put(fruit, currentQuantity - quantity);
        } else {
            throw new IllegalArgumentException("Not enough " + fruit + " in stock for purchase.");
        }
    }
}
