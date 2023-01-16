package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.StorageDao;

public interface OperationHandler {
    void makeOperation(String name, int quantity, StorageDao storageDao);
}
