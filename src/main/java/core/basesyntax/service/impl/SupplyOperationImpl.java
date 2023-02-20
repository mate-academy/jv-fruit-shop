package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    private StorageDao storageDao;

    public SupplyOperationImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void registerTransaction(FruitTransaction transaction) {
        if (storageDao.getQuantity(transaction.getFruit()) != 0) {
            int currentQty = storageDao.getQuantity(transaction.getFruit());
            storageDao.add(transaction.getFruit(), currentQty + transaction.getQuantity());
        } else {
            storageDao.add(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
