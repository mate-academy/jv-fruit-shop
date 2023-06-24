package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnOperationImpl implements OperationHandler {
    private StorageDao storageDao;

    public ReturnOperationImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void registerTransaction(FruitTransaction transaction) {
        int currentQty = storageDao.getQuantity(transaction.getFruit());
        storageDao.add(transaction.getFruit(), currentQty + transaction.getQuantity());
    }
}
