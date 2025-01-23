package core.basesyntax.operations.operationhandlers;

import core.basesyntax.storagedao.StorageDao;
import core.basesyntax.storagedao.StorageDaoImpl;

public interface OperationHandler {
    StorageDao storageDao = new StorageDaoImpl();
    void handle(String fruit, int quantity);
}
