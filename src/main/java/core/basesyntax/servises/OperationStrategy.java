package core.basesyntax.servises;

public interface OperationStrategy {
    public OperationHandler get(OperationType operation);
}
