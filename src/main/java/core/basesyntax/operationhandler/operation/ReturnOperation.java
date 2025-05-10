package core.basesyntax.operationhandler.operation;

import core.basesyntax.storage.StorageDaoImpl;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        storageDao.add(fruit, quantity);
    }
}
