package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity) {
        int storedAmount = Storage.STORAGE.getOrDefault(fruit, 0);
        if (storedAmount - quantity < 0) {
            throw new RuntimeException("Quantity of " + fruit
                    + " in storage is less than " + quantity);
        }
        Storage.STORAGE.put(fruit, storedAmount - quantity);
    }
}
