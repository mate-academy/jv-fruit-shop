package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorageDao;

public class OperationHandlerPurchase implements OperationHandler {
    @Override
    public void makeChanges(FruitStorageDao db, String fruit, int count) {
        db.decrement(fruit, count);
    }
}
