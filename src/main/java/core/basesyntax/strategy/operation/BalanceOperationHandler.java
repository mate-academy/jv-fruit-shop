package core.basesyntax.strategy.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getQuantity(int prev, int value) {
        return value;
    }
}
