package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    private Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storage.remove(fruit, quantity);
    }
}
