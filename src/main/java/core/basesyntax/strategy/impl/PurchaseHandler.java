package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyChanges(FruitTransaction fruitTransaction) {
        if (storageDao.getRemainingFruits(fruitTransaction.getFruit())
                < fruitTransaction.getQuantity()) {
            throw new RuntimeException("There are no enough fruits");
        }
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Purchase cannot be negative");
        }
        storageDao.updateValues(fruitTransaction.getFruit(),
                -fruitTransaction.getQuantity());
    }
}
