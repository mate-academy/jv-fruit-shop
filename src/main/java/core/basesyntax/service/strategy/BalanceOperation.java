package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private FruitStorageDao storageDao;

    public BalanceOperation(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storageDao.update(transaction.getFruit(), transaction.getQuantity());
    }
}
