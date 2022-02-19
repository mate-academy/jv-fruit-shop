package service.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer getOperation(Integer input) {
        return -input;
    }
}
