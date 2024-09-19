package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ActionHandler;

public class PurchaseAction implements ActionHandler {
    public void apply(String fruit, int quantity) {
        Storage.removeFruit(fruit, quantity);
    }
}
