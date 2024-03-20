package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handleFruitOperation(String fruit, Integer quantity) {
        Storage.fruits.computeIfPresent(fruit, (key, value) -> value + quantity);
        Storage.fruits.putIfAbsent(fruit, quantity);
    }
}
