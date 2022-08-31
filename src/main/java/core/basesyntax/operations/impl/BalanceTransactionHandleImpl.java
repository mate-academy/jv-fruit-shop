package core.basesyntax.operations.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.TransactionHandle;

public class BalanceTransactionHandleImpl implements TransactionHandle {
    private StorageDao storage;

    public BalanceTransactionHandleImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
