package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.StorageDao;
import core.basesyntax.storage.StorageDaoImpl;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = storageDao.getAmount(transaction.getFruit());
        int purchase = transaction.getQuantity();

        if (purchase > currentQuantity) {
            if (currentQuantity == 1) {
                throw new RuntimeException("Purchase rejected. There is "
                        + currentQuantity + " fruit in storage");
            }
            throw new RuntimeException("Purchase rejected. There are "
                    + currentQuantity + " fruits in storage");
        }
        int newQuantity = (currentQuantity - purchase);
        storageDao.update(transaction.getFruit(), newQuantity);
    }
}
