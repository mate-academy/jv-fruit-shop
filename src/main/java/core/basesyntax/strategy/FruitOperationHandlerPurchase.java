package core.basesyntax.strategy;

public class FruitOperationHandlerPurchase implements FruitOperationHandler {
    @Override
    public int handle(int sum, int quantity) {
        return sum - quantity;
    }
}
