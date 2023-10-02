package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;

public interface OperationHandler {
    void makeChanges(FruitDao db, String fruit, int count);
}
