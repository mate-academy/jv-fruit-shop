package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void processOperation(String fruit, Integer value) {
        storageDao.addAmount(fruit, value);
    }
}
