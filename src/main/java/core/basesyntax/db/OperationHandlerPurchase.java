package core.basesyntax.db;

public class OperationHandlerPurchase implements OperationHandler {
    @Override
    public void makeChanges(FruitDao db, String fruit, int count) {
        db.decrement(fruit, count);
    }
}
