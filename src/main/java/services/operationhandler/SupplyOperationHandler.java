package services.operationhandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int calculateQuantity(int balance, int quantity) {
        return balance + quantity;
    }
}
