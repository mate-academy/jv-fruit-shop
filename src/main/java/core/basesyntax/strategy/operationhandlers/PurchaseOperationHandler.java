package core.basesyntax.strategy.operationhandlers;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int quantity) {
        return Math.negateExact(quantity);
    }
}
