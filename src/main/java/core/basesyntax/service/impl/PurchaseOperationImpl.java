package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationImpl implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void registerTransaction(FruitTransaction transaction) {
        if (storageDao.containsFruit(transaction.getFruit())) {
            int currentQty = storageDao.checkAvailableQuantity(transaction.getFruit());
            if (currentQty >= transaction.getQuantity()) {
                storageDao.add(transaction.getFruit(), currentQty - transaction.getQuantity());
            } else {
                throw new RuntimeException("Storage contains only - " + currentQty
                        + " " + transaction.getFruit().getName()
                        + " products. Current transaction needs - " + transaction.getQuantity());
            }
        } else {
            throw new RuntimeException("Storage does not contain "
                    + transaction.getFruit().getName() + " product!");
        }
    }
}
