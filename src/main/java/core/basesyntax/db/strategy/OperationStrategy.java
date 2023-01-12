package core.basesyntax.db.strategy;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
