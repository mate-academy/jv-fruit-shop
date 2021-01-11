package core.basesyntax.service.operation;

public interface OperationStrategy {
    OperationHandler get(Operation.Type operation);
}
