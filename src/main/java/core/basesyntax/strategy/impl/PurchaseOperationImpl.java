package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyOperation;

public class PurchaseOperationImpl implements StrategyOperation {
    private StorageDao storageDao;

    public PurchaseOperationImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.decreaseFruitQuantity(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
