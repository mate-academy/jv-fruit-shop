package core.basesyntax.service.operationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getValueByOperation(int value) {
        return - value;
    }
}
