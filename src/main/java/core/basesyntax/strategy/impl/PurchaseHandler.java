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
        Integer remainingFruits = storageDao.getRemainingFruits(fruitTransaction.getFruit());
        if (remainingFruits < fruitTransaction.getQuantity()) {
            throw new RuntimeException("There are no enough fruits");
        }
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Purchase cannot be negative");
        }
        int newQuantity = remainingFruits - fruitTransaction.getQuantity();
        storageDao.updateValues(fruitTransaction.getFruit(), newQuantity);
    }
}
