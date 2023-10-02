package core.basesyntax.db;

public class OperationHandlerSupply implements OperationHandler {
    @Override
    public void makeChanges(FruitDao db, String fruit, int count) {
        db.increment(fruit, count);
    }
}
