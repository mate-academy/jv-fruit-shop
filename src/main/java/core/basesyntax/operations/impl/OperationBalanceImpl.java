package core.basesyntax.operations.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.Operation;

public class OperationBalanceImpl implements Operation {
    private StorageDao storage;

    public OperationBalanceImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void executeOperation(FruitTransaction fruitTransaction) {
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
