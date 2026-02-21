package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Integer currentQuantity = Storage.getQuantity(fruit);
        if (currentQuantity == null || currentQuantity < quantity) {
            throw new RuntimeException("Not enough fruit "
                    + fruit + " in storage to remove. "
                    + "Current: " + currentQuantity + ", "
                    + "Requested " + quantity);
        }
        Storage.putQuantity(fruit, currentQuantity - quantity);
    }
}
