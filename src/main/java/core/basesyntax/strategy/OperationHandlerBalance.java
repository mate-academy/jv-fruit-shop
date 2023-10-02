package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;

public class OperationHandlerBalance implements OperationHandler {
    @Override
    public void makeChanges(FruitDao db, String fruit, int count) {
        db.increment(fruit, count);
    }
}
