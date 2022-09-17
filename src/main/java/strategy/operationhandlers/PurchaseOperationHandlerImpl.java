package strategy.operationhandlers;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public int getOperationQuantity(int inputQuantity) {
        return - inputQuantity;
    }
}
