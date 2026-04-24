package core.basesyntax;

public interface OperationHandlerProvider {
    OperationHandler get(FruitTransaction.Operation operation);
}
