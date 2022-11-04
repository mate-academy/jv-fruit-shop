package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationStrategy implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void processFruitTransactionOperation(FruitTransaction fruitTransaction) {
        storageDao.addFruitQuantity(fruitTransaction);
    }
}
