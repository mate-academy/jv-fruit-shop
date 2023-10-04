package core.basesyntax.strategy;

public class SupplyHandler implements OperationHandler {
    @Override
    public int operate(int amount, int quantity) {
        return amount + quantity;
    }
}
