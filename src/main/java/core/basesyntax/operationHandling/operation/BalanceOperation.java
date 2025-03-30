package core.basesyntax.operationHandling.operation;

import core.basesyntax.storage.StorageDaoImpl;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        storageDao.add(fruit, quantity);
    }
}
