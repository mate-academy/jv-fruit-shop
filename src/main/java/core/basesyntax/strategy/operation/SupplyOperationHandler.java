package core.basesyntax.strategy.operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(int prev, int value) {
        return prev + value;
    }
}
