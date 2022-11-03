package services.operationhandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int calculateQuantity(int balance, int quantity) {
        return quantity;
    }
}
