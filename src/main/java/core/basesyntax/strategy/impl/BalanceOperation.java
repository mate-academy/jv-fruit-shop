package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        storageDao.putValue(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
