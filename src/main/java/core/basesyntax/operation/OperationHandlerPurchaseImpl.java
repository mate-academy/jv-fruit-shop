package core.basesyntax.operation;

public class OperationHandlerPurchaseImpl implements OperationHandler {
    @Override
    public int operate(int first, int second) {
        if (first - second < 0) {
            throw new RuntimeException("Have no enough product, fruits in stock : " + first
            + ", but want to buy: " + second);
        }
        return first - second;
    }
}
