package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    private StorageDao storageDao;

    public BalanceOperationImpl(StorageDao storage) {
        this.storageDao = storage;
    }

    @Override
    public void registerTransaction(FruitTransaction transaction) {
        storageDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
