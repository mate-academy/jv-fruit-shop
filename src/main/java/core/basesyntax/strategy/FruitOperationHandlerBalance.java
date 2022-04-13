package core.basesyntax.strategy;

public class FruitOperationHandlerBalance implements FruitOperationHandler {
    @Override
    public int handle(int sum, int quantity) {
        return sum + quantity;
    }
}
