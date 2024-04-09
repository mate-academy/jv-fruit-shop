package core.basesyntax.strategy.operationhandlers;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int quantity) {
        return quantity;
    }
}
