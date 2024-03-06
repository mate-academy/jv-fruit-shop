package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruit, int quantity) {
        Integer available = Storage.fruits.get(fruit);
        if (available == null) {
            throw new RuntimeException("Incorrect return operation. Such item '" + fruit
                    + "' was not sold from the shop!");
        }
        Storage.fruits.put(fruit, available + quantity);
    }
}
