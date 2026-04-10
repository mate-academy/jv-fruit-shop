package core.basesyntax.service;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
