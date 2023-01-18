package strategy.handler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer getAmount(int quantity) {
        return -quantity;
    }
}
