package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageFruits;
import core.basesyntax.strategy.Strategy;

public class BalanceStrategy implements Strategy {
    @Override
    public void makeOperation(String fruit, int value) {
        StorageFruits.fruits.put(fruit, value);
    }
}
