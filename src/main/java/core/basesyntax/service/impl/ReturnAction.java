package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ActionHandler;

public class ReturnAction implements ActionHandler {
    public void apply(String fruit, int quantity) {
        Storage.addFruit(fruit, quantity);
    }
}
