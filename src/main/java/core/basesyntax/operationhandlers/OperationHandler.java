package core.basesyntax.operationhandlers;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    FruitStorageDao FRUIT_STORAGE_DAO = new FruitStorageDaoImpl();
    void handle(FruitTransaction fruitTransaction);
}
