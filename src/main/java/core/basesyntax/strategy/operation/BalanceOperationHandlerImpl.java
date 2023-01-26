package core.basesyntax.strategy.operation;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public int getUpdatedAmount(int currentAmount, int operationAmount) {
        return operationAmount;
    }
}
