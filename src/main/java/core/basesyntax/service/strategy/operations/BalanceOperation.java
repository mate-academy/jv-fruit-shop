package core.basesyntax.service.strategy.operations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        storageDao.save(transaction.getFruit(), transaction.getQuantity());
    }
}
