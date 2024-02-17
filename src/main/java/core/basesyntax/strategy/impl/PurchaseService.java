package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.Strategy;
import java.util.Map;

public class PurchaseService implements Strategy {
    @Override
    public void processData(Map<String, Integer> fruitData, String fruit, int quantity) {
        fruitData.merge(fruit, -quantity, Integer::sum);

        if (fruitData.get(fruit) < 0) {
            throw new IllegalArgumentException("Not enough " + fruit + " in stock for purchase.");
        }
    }
}
