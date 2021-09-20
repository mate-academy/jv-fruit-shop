package core.basesyntax.operation;

public interface OperationStrategy {
    Operation getOperation(OperationType type);
}
