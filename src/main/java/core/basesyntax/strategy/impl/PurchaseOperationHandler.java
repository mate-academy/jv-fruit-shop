package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitOperationHandler;

public class PurchaseOperationHandler implements FruitOperationHandler {
    private static final int MIN_QUANTITY_VALUE = 0;
    private StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        if (storageDao == null) {
            throw new RuntimeException("StorageDao can't be null");
        }
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = storageDao.get(fruitTransaction.getFruitName());
        int newQuantity = fruit.getQuantity() - fruitTransaction.getQuantity();
        if (newQuantity < MIN_QUANTITY_VALUE) {
            throw new RuntimeException("Quantity must be not less than " + MIN_QUANTITY_VALUE);
        }
        fruit.setQuantity(newQuantity);
    }
}
