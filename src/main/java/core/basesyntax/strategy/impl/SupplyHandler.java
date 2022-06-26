package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeOperation(FruitShopTransactions fruitTransaction) {
        int newQuantity = fruitTransaction.getQuantity()
                + storageDao.getCurrentFruits(fruitTransaction.getFruit());
        storageDao.update(fruitTransaction.getFruit(), newQuantity);
    }
}
