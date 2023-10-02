package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;

public class OperationHandlerPurchase implements OperationHandler {
    @Override
    public void makeChanges(FruitDao db, String fruit, int count) {
        db.decrement(fruit, count);
    }
}
