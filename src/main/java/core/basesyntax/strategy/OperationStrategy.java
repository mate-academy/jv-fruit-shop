package core.basesyntax.strategy;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
