package core.basesyntax.strategy;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int operation(int amount, int quantity) {
        return amount + quantity;
    }
}
