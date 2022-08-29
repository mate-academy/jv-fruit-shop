package core.basesyntax.strategy;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getResultOfOperation(int quantity) {
        return -quantity;
    }
}
