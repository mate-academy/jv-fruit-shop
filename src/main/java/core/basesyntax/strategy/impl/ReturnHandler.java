package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storageDao.create(
                fruitTransaction.getFruit(),
                storageDao.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
