package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void execute(FruitTransaction transaction, StorageDao storageDao);
}
