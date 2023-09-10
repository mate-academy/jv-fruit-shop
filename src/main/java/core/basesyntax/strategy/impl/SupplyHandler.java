package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity) {
        Storage.STORAGE.put(fruit, Storage.STORAGE.getOrDefault(fruit, 0) + quantity);
    }
}
