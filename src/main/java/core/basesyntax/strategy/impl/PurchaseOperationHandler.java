package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.StorageDao;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = storageDao.getAmount(transaction.getFruit());
        int purchase = transaction.getQuantity();

        if (purchase > currentQuantity) {
            throw new RuntimeException("Purchase rejected. There are "
                    + currentQuantity + " fruits in storage");
        }
        int newQuantity = (currentQuantity - purchase);
        storageDao.update(transaction.getFruit(), newQuantity);
    }
}
