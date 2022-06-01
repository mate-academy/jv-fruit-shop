package strategy;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int initialQuantity, int amount) {
        return initialQuantity - amount;
    }
}
