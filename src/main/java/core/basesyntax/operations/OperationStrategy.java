package core.basesyntax.operations;

public interface OperationStrategy {
    OperationHandler getOperationHandler(String operation);
}
