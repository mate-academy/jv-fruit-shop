package core.basesyntax.service.handler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int inputQuantity) {
        int resultQuantity = currentQuantity - inputQuantity;
        if (resultQuantity < 0) {
            throw new RuntimeException("Wrong quantity for the purchase operation");
        }
        return resultQuantity;
    }
}
