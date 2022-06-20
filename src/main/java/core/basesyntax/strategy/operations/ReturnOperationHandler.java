package core.basesyntax.strategy.operations;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int getOperationalQuantity(int quantity) {
        return quantity * (-1);
    }
}
