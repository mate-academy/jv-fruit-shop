package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationBalance implements OperationHandler {
    private static final FruitStorageDao storageDao = new FruitStorageDaoImpl();

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        storageDao.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
