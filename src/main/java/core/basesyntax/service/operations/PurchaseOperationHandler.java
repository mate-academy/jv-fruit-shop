package core.basesyntax.service.operations;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getQuantity(int quantity) {
        return -quantity;
    }
}
