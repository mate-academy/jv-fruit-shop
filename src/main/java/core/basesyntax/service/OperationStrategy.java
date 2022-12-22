package core.basesyntax.service;

public interface OperationStrategy {
    OperationExecutor get(FruitTransaction.Operation operation);
}
