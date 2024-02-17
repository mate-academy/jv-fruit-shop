package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.Strategy;
import java.util.Map;

public class ReturnService implements Strategy {
    @Override
    public void processData(Map<String, Integer> fruitData, String fruit, int quantity) {
        fruitData.merge(fruit, quantity, Integer::sum);
    }
}
