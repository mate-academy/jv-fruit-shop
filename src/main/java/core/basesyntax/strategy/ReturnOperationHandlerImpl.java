package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.getQuantity(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
