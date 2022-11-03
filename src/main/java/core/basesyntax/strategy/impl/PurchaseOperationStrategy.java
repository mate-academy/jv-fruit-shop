package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationStrategy implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void processFruitTransactionOperation(FruitTransaction fruitTransaction) {
        storageDao.subtractFruitQuantity(fruitTransaction);
    }
}
