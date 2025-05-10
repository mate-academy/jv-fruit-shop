package core.basesyntax.transactions;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
