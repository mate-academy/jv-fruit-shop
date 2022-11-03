package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationPurchase implements OperationHandler {
    private final FruitStorageDao storageDao;

    public OperationPurchase(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getQuantity(fruitTransaction.getFruit());
        storageDao.put(fruitTransaction.getFruit(),
                currentQuantity - fruitTransaction.getQuantity());
    }
}
