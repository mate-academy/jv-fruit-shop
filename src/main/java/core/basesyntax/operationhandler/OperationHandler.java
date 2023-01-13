package core.basesyntax.operationhandler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public abstract class OperationHandler {
    protected static final StorageDao storageDao = new StorageDaoImpl();

    public abstract void handle(FruitTransaction fruitTransaction);
}
