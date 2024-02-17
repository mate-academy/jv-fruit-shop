package core.basesyntax.service.Operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public interface OperationHandler {
     void handle(String fruit, int amount);
}
