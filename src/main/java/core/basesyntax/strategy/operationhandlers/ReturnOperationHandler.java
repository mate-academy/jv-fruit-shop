package core.basesyntax.strategy.operationhandlers;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int quantity) {
        return quantity;
    }
}
