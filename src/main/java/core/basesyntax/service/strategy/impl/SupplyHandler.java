package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {

    private final StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public Integer processTransaction(FruitTransaction transaction) {
        int balance = 0;
        if (storageDao.getAmount(transaction.getFruit()) != null) {
            balance = storageDao.getAmount(transaction.getFruit());
        }
        return balance += transaction.getQuantity();
    }
}
