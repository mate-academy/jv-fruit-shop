package core.basesyntax.operations.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.Operation;

public class OperationPurschaseImpl implements Operation {
    private StorageDao storage;

    public OperationPurschaseImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void executeOperation(FruitTransaction fruitTransaction) {
        storage.remove(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
