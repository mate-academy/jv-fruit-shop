package services.operationhandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int calculateQuantity(int balance, int quantity) {
        return balance - quantity;
    }
}
