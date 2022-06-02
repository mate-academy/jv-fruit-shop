package core.basesyntax.strategy;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int processOperation(int initialQuantity, int amount) {
        return initialQuantity + amount;
    }
}
