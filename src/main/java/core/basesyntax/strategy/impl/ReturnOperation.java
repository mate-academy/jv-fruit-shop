package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getValue(fruitTransaction.getFruit());
        storageDao.putValue(fruitTransaction.getFruit(),
                currentQuantity + fruitTransaction.getQuantity());
    }
}
