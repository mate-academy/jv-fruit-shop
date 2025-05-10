package core.basesyntax.operationhandler.operation;

import core.basesyntax.storage.StorageDaoImpl;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        storageDao.remove(fruit, quantity);
    }
}
