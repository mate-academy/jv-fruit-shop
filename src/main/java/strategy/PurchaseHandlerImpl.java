package strategy;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public int getAmount(int quantity) {
        return -quantity;
    }
}
