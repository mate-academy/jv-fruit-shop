package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruit, int quantity) {
        Integer available = Storage.fruits.get(fruit);
        available = available == null ? 0 : available;
        Storage.fruits.put(fruit, available + quantity);
    }
}
