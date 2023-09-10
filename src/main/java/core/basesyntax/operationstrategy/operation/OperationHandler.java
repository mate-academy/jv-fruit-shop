package core.basesyntax.operationstrategy.operation;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;

public interface OperationHandler {
    StorageDao STORAGE_DAO = new StorageDaoImpl();

    void processOperation(String item, Integer value);
}
