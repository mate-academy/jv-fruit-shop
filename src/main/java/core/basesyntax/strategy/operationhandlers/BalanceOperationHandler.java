package core.basesyntax.strategy.operationhandlers;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int quantity) {
        return quantity;
    }
}
