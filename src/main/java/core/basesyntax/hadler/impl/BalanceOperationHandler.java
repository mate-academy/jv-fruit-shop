package core.basesyntax.hadler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storageDao.save(transaction.getFruit(), transaction.getQuantity());
    }
}
