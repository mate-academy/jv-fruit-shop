package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class Purchase implements OperationHandler {
    @Override
    public void handleFruitOperation(String fruit, Integer quantity) {
        if (Storage.fruits.get(fruit) < quantity) {
            throw new RuntimeException("Not enough " + fruit + "we have only " + quantity);
        }
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) - quantity);
    }
}
