package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void changeQuantity(FruitTransaction fruitTransaction) {
        storageDao.updateData(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
