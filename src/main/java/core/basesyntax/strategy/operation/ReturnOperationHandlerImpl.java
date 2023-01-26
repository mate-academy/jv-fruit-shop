package core.basesyntax.strategy.operation;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public int getUpdatedAmount(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
