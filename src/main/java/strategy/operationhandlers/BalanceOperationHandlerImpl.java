package strategy.operationhandlers;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public int getOperationQuantity(int inputQuantity) {
        return inputQuantity;
    }
}
