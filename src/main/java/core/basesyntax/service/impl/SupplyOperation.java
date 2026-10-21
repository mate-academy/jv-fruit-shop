package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;

public class SupplyOperation implements OperationHandler {
    private Storage storage;

    public SupplyOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storage.add(fruit, quantity);
    }
}
