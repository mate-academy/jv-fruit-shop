package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storageDao.create(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
