package core.basesyntax.operationstrategy.operation;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void processOperation(String item, Integer value) {
        storageDao.substractAmount(item, value);
    }
}
