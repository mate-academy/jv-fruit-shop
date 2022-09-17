package strategy.operationhandlers;

public class SupplyOperationHandlerImpl implements OperationHandler {

    @Override
    public int getOperationQuantity(int inputQuantity) {
        return inputQuantity;
    }
}
