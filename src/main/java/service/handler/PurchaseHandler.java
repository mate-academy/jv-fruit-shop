package service.handler;

public class PurchaseHandler implements OperationHandler {

    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue - value;
    }
}
