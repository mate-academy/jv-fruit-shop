package core.basesyntax;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
