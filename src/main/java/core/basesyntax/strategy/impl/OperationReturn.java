package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationReturn implements OperationHandler {
    private final FruitStorageDao storageDao;

    public OperationReturn(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getQuantity(fruitTransaction.getFruit());
        storageDao.put(fruitTransaction.getFruit(),
                currentQuantity + fruitTransaction.getQuantity());
    }
}
