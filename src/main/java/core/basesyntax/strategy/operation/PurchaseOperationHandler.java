package core.basesyntax.strategy.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(int prev, int value) {
        return prev - value;
    }
}
