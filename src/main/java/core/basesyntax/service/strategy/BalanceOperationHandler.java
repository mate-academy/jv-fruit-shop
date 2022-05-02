package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operate(FruitTransaction transaction) {
        storageDao.compute(transaction.getFruit(), transaction.getQuantity());
    }
}
