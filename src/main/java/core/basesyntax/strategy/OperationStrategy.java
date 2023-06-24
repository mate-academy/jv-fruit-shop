package core.basesyntax.strategy;

public interface OperationStrategy {
    OperationHandler getOperation(String operationType);
}
