package core.basesyntax.operation;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
