package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitOperationHandler;

public class SupplyOperationHandler implements FruitOperationHandler {
    private StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        int newQuantity = storageDao.get(fruitTransaction.getFruitName())
                + fruitTransaction.getQuantity();
        storageDao.add(fruitTransaction.getFruitName(), newQuantity);
    }
}
