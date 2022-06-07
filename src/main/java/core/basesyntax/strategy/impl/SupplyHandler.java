package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyChanges(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Supply cannot be negative");
        }
        int remainingFruits = storageDao.getRemainingFruits(fruitTransaction.getFruit()) == null
                ? 0 : storageDao.getRemainingFruits(fruitTransaction.getFruit());
        int newQuantity = fruitTransaction.getQuantity() + remainingFruits;
        storageDao.updateValues(fruitTransaction.getFruit(), newQuantity);
    }
}
