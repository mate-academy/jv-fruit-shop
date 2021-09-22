package core.basesyntax.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int newAmountByOperation(int amount, int newAmount) {
        return newAmount;
    }
}
