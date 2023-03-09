package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationSupply implements OperationHandler {
    private final FruitStorageDao storageDao;

    public OperationSupply(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getQuantity(fruitTransaction.getFruit());
        storageDao.put(fruitTransaction.getFruit(),
                currentQuantity + fruitTransaction.getQuantity());
    }
}
