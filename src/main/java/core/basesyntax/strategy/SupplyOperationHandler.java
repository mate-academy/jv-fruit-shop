package core.basesyntax.strategy;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int processOperation(int initialQuantity, int amount) {
        return initialQuantity + amount;
    }
}
