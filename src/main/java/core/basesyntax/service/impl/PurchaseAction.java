package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ActionHandler;

public class PurchaseAction implements ActionHandler {
    @Override
    public void apply(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be negative");
        }
        Storage.removeFruit(fruit, quantity);
    }
}
