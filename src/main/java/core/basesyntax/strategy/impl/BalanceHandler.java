package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storageDao.create(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
