package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.InsufficientQuantityException;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity, Storage storage) {
        if (fruit == null || fruit.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty.");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        int currentQuantity = storage.getQuantity(fruit);

        if (currentQuantity < quantity) {
            throw new InsufficientQuantityException("Not enough quantity of "
                    + fruit + " in storage to return.");
        }

        storage.addEntry(fruit, currentQuantity + quantity);
        currentQuantity = storage.getQuantity(fruit);
        System.out.println("Returned " + quantity + " " + fruit + "(s). Now: " + currentQuantity);
    }
}
