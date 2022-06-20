package core.basesyntax.strategy.operations;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getOperationalQuantity(int quantity) {
        return quantity;
    }
}
