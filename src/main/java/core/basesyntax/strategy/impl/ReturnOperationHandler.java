package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
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
            throw new RuntimeException("Return quantity must be positive for " + fruit);
        }
        storageDao.addFruitQuantity(fruit, quantity);
    }
}
