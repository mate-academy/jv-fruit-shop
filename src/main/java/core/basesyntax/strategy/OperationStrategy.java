package core.basesyntax.strategy;

public interface OperationStrategy {
    OperationHandler getOperationType(String key);
}
