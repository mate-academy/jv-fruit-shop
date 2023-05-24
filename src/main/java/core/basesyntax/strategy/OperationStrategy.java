package core.basesyntax.strategy;

public interface OperationStrategy {
    OperationProcessor get(FruitTransaction.Operation operation);
}
