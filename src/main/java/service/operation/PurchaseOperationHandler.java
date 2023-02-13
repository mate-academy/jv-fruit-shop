package service.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getValueByOperation(int value) {
        return - value;
    }
}
