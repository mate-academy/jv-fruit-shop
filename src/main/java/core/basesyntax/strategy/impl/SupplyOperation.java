package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity, Storage storage) {
        int currentQuantity = storage.getQuantity(fruit);
        storage.addEntry(fruit, currentQuantity + quantity);
        currentQuantity = storage.getQuantity(fruit);
        System.out.println("Added " + quantity + " " + fruit + "(s). Now: " + currentQuantity);
    }
}
