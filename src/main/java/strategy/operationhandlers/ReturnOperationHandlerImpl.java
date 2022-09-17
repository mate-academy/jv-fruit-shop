package strategy.operationhandlers;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public int getOperationQuantity(int inputQuantity) {
        return inputQuantity;
    }
}
