package core.basesyntax.strategy.impl;

import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {

    @Override
    public void handle(String fruit, int quantity) {
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + quantity);
    }
}
