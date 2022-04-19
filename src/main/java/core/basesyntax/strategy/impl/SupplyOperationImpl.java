package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyOperation;

public class SupplyOperationImpl implements StrategyOperation {
    private StorageDao storageDao;

    public SupplyOperationImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.increaseFruitQuantity(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
