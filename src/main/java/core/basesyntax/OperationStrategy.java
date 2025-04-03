package core.basesyntax;

public interface OperationStrategy {
    public OperationHandler getHandler(FruitTransaction.Operation operation);
}
