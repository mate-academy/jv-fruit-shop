package core.basesyntax.strategy;

public class PurchaseHandler implements OperationHandler {

    @Override
    public int apply(int current, int transaction) {
        if (current < transaction) {
            throw new RuntimeException("Not enough fruit in stock!");
        }
        return current - transaction;
    }
}
