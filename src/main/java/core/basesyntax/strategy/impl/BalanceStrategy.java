package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.Strategy;

public class BalanceStrategy implements Strategy {
    @Override
    public void makeOperation(String fruit, int value) {
        Storage.fruits.put(fruit, value);
    }
}
