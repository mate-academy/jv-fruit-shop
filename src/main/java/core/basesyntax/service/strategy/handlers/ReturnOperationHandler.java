package core.basesyntax.service.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        storageDao.addToDataBase(fruitTransaction.getFruit(),
                storageDao.getByKey(fruitTransaction.getFruit()) + fruitTransaction.getQuantity());
    }
}
