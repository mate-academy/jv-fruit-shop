package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;

public interface OperationHandler {

    void performOperation(String fruitName, int amount, StorageDao storageDao);
}
