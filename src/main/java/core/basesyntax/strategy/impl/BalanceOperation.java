package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    public void apply(String fruit, int quantity, Storage storage) {
        if (fruit == null || fruit.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number.");
        }

        storage.addEntry(fruit, quantity);
        int currentQuantity = storage.getQuantity(fruit);
        System.out.println("Left from yesterday: " + currentQuantity + " " + fruit + "(s).");
    }
}
