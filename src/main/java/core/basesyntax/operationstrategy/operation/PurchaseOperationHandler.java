package core.basesyntax.operationstrategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void processOperation(String fruit, Integer value) {
        storageDao.substractAmount(fruit, value);
    }
}
