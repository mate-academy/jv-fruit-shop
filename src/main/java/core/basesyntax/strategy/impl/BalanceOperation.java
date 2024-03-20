package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handleFruitOperation(String fruit, Integer quantity) {
        Storage.fruits.compute(fruit, (key, value)
                -> (value == null) ? quantity : value + quantity);
    }
}
