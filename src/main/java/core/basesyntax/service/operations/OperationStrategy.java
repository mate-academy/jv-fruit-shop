package core.basesyntax.service.operations;

public interface OperationStrategy {
    OperationHandler chooseOperation(Operation operation);
}
