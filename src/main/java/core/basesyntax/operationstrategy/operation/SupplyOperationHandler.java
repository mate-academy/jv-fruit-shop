package core.basesyntax.operationstrategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void processOperation(String fruit, Integer value) {
        storageDao.addAmount(fruit, value);
    }
}
