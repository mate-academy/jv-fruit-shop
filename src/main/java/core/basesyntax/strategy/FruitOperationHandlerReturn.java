package core.basesyntax.strategy;

public class FruitOperationHandlerReturn implements FruitOperationHandler {
    @Override
    public int handle(int sum, int quantity) {
        return sum + quantity;
    }
}
