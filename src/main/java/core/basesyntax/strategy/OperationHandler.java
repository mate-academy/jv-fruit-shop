package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorageDao;

public interface OperationHandler {
    void makeChanges(FruitStorageDao db, String fruit, int count);
}
