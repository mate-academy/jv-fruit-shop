package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        if (storageDao == null) {
            throw new RuntimeException("Cannot access to storage dao: parameter is null");
        }
        this.storageDao = storageDao;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (quantity <= 0) {
            throw new RuntimeException("Purchase quantity must be positive for " + fruit);
        }
        int currentBalance = storageDao.getFruitQuantity(fruit);
        if (currentBalance < quantity) {
            throw new RuntimeException(
                    "Not enough " + fruit + " in shop for purchase");
        }
        storageDao.deductFruitQuantity(fruit, quantity);
    }
}
