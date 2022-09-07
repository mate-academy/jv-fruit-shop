package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
