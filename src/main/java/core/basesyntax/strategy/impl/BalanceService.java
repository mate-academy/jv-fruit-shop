package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.Strategy;
import java.util.Map;

public class BalanceService implements Strategy {
    @Override
    public void processData(Map<String, Integer> fruitData, String fruit, int quantity) {
        fruitData.put(fruit, fruitData.getOrDefault(fruit, 0) + quantity);
    }
}

