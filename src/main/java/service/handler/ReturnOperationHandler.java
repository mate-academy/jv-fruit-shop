package service.handler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int calculateQuantity(int balance, int quantity) {
        return balance + quantity;
    }
}
