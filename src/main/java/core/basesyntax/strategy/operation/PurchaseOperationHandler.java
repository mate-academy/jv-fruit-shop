package core.basesyntax.strategy.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(int prev, int value) {
        if (value > prev) {
            throw new IllegalArgumentException("Cannot purchase more than"
                    + " available in stock. Requested: "
                    + value + ", Available: " + prev);
        }
        return prev - value;
    }
}
