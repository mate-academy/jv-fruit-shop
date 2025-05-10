package core.basesyntax.operation.handler;

import core.basesyntax.storagedao.StorageDao;
import core.basesyntax.storagedao.StorageDaoImpl;

public abstract class AbstractOperationHandler implements OperationHandler {
    protected final StorageDao storageDao = new StorageDaoImpl();
}
