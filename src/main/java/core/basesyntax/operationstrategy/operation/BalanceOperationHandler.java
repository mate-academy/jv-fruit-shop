package core.basesyntax.operationstrategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void processOperation(String fruit, Integer value) {
        storageDao.add(fruit, value);
    }
}
