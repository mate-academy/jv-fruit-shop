package core.basesyntax.strategy;

public class BalanceHandler implements OperationHandler {
    @Override
    public int operate(int amount, int quantity) {
        return quantity;
    }
}
