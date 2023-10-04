package core.basesyntax.strategy;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int operate(int amount, int quantity) {
        return amount - quantity;
    }
}
