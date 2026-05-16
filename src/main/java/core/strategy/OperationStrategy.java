package core.strategy;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
