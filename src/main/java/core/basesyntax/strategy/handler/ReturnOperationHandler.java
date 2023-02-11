package core.basesyntax.strategy.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public int execute(FruitTransaction transaction) {
        return storageDao.update(transaction.getFruit(), transaction.getQuantity());
    }
}
