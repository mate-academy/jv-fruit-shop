package core.basesyntax.strategy;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int operation(int amount, int quantity) {
        return quantity;
    }
}
