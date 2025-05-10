package core.basesyntax.strategy.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int executeOperation(int initBalance, int quantity) {
        return initBalance - quantity;
    }
}
