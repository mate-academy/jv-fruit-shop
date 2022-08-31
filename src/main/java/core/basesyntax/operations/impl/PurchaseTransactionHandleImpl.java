package core.basesyntax.operations.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.TransactionHandle;

public class PurchaseTransactionHandleImpl implements TransactionHandle {
    private StorageDao storage;

    public PurchaseTransactionHandleImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        storage.remove(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
