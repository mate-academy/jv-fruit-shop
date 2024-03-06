package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruit, int quantity) {
        Integer available = Storage.fruits.get(fruit);
        if (available == null) {
            throw new RuntimeException("Incorrect purchase operation. No such item '" + fruit
                    + "' present in the shop!");
        }
        available = available - quantity;
        if (available < 0) {
            throw new RuntimeException("Incorrect purchase operation. Not enough items '" + fruit
                    + "' for sale!");
        }
        Storage.fruits.put(fruit, available);
    }
}
