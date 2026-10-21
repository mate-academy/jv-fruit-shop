package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationHandler {
    private Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storage.add(fruit, quantity);
    }
}
