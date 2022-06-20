package core.basesyntax.strategy.operations;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getOperationalQuantity(int quantity) {
        return quantity;
    }
}
