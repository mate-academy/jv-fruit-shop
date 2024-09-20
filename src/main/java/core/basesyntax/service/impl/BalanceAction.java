package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ActionHandler;

public class BalanceAction implements ActionHandler {
    @Override
    public void apply(String fruit, int quantity) {
        Storage.setBalance(fruit, quantity);
    }
}
