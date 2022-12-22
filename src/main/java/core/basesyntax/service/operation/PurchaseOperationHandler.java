package core.basesyntax.service.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int quantity) {
        return - quantity;
    }
}
