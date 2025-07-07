package core.basesyntax.handlers.impl;

import core.basesyntax.data.Storage;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String nameFruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + quantity);
        }
        int current = Storage.getAssortment().getOrDefault(nameFruit, 0);
        int updated = current + quantity;
        Storage.getAssortment().put(nameFruit, updated);
    }
}
