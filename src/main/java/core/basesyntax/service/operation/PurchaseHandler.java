package core.basesyntax.service.operation;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int getOperationAction(int quantity) {
        return -quantity;
    }
}
