package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity, Storage storage) {
        if (fruit == null || fruit.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit can't be null or empty.");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative.");
        }

        int currentQuantity = storage.getQuantity(fruit);
        storage.addEntry(fruit, currentQuantity + quantity);
        currentQuantity = storage.getQuantity(fruit);
        System.out.println("Added " + quantity + " " + fruit + "(s). Now: " + currentQuantity);
    }
}
