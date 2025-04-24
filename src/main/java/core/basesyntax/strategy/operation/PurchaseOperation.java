package core.basesyntax.strategy.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int makeOperation(int amountOfOperation) {
        return -amountOfOperation;
    }
}
