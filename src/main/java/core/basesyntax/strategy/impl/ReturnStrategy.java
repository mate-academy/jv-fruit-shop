package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.Strategy;

public class ReturnStrategy implements Strategy {
    @Override
    public void makeOperation(String fruit, int value) {
        Integer previousValue = Storage.fruits.get(fruit);
        Storage.fruits.put(fruit, previousValue + value);
    }
}
