package core.basesyntax.strategy.operation;

public interface OperationHandler {
    int getUpdatedAmount(int currentAmount, int operationAmount);
}
