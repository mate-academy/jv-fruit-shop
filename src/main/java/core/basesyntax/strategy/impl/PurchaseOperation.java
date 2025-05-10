package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.InsufficientQuantityException;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity, Storage storage) {
        if (fruit == null || fruit.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty.");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        int currentQuantity = storage.getQuantity(fruit);
        int updatedQuantity = currentQuantity - quantity;

        if (updatedQuantity < 0) {
            throw new InsufficientQuantityException("Not enough " + fruit + " in storage. Current: "
                    + currentQuantity + ", trying to remove: " + quantity);
        }

        storage.addEntry(fruit, updatedQuantity);
        System.out.println("Sold " + quantity + " " + fruit + "(s). Left: " + updatedQuantity);
    }
}
