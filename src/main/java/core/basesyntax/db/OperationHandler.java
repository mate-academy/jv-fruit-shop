package core.basesyntax.db;

public interface OperationHandler {
    void makeChanges(FruitDao db, String fruit, int count);
}
