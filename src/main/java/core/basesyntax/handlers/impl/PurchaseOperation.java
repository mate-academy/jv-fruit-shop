package core.basesyntax.handlers.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.data.Storage;
import core.basesyntax.handlers.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private int current = 0;

    @Override
    public void apply(FruitTransaction transaction) {
        String nameFruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        Integer current = Storage.getAssortment().get(nameFruit);
        if (current == null) {
            throw new IllegalArgumentException("Fruit '" + nameFruit + "' not found in storage!");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Negative quantity is not allowed: " + quantity);
        }
        int result = current - quantity;
        if (result < 0) {
            throw new IllegalArgumentException("Not enough '"
                    + nameFruit + "' in storage! Only " + current + " left.");
        }
        Storage.getAssortment().put(nameFruit, result);
    }
}
