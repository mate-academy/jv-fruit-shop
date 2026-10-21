package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;

public class BalanceOperation implements OperationHandler {
    private Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storage.set(fruit, quantity);
    }
}
