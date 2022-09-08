package core.basesyntax.strategy;

public interface OperationStrategy {
    OperationHandler getByOperation(String operation);
}
