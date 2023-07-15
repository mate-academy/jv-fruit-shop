package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitOperationHandler;

public class PurchaseOperationHandler implements FruitOperationHandler {
    private static final int MIN_QUANTITY_VALUE = 0;
    private StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        int newQuantity = storageDao.get(fruitTransaction.getFruitName())
                - fruitTransaction.getQuantity();
        if (newQuantity < MIN_QUANTITY_VALUE) {
            throw new RuntimeException("Quantity must be not less than " + MIN_QUANTITY_VALUE);
        }
        storageDao.add(fruitTransaction.getFruitName(), newQuantity);
    }
}
