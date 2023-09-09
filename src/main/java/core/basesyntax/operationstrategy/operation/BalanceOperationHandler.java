package core.basesyntax.operationstrategy.operation;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void processOperation(String item, Integer value) {
        storageDao.add(item, value);
    }
}
