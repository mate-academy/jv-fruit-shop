package core.basesyntax.strategy.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(int prev, int value) {
        return value;
    }
}
