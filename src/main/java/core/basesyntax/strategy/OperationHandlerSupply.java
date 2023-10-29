package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorageDao;

public class OperationHandlerSupply implements OperationHandler {
    @Override
    public void makeChanges(FruitStorageDao db, String fruit, int count) {
        db.increment(fruit, count);
    }
}
