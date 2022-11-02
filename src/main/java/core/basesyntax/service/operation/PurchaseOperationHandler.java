package core.basesyntax.service.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int doOperation(int balance, int quantity) {
        return balance - quantity;
    }
}
