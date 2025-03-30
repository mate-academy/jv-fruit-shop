package core.basesyntax.operationHandling.operation;

import core.basesyntax.storage.StorageDaoImpl;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        storageDao.remove(fruit, quantity);
    }
}
