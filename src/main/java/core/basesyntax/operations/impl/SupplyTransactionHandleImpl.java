package core.basesyntax.operations.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.TransactionHandle;

public class SupplyTransactionHandleImpl implements TransactionHandle {
    private StorageDao storage;

    public SupplyTransactionHandleImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        storage.supply(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
