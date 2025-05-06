package core.basesyntax.strategy.operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(int prev, int value) {
        return prev + value;
    }
}
