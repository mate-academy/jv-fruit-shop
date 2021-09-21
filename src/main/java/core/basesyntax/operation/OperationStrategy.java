package core.basesyntax.operation;

public interface OperationStrategy {
    OperationHandler getOperation(OperationType type);
}
