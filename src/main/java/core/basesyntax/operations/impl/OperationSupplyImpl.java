package core.basesyntax.operations.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.Operation;

public class OperationSupplyImpl implements Operation {
    private StorageDao storage;

    public OperationSupplyImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void executeOperation(FruitTransaction fruitTransaction) {
        storage.supply(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
