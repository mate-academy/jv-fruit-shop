package core.basesyntax.operations;

public interface OperationStrategy {
    OperationHandler getOperation(String operation);
}
