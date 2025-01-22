package core.basesyntax.tranasctions;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
