package core.basesyntax.strategy;

public class FruitOperationsHandlerReturn implements FruitOperationsHandler {
    @Override
    public int getResultOfFruitOperation(int sum, int quantity) {
        return sum + quantity;
    }
}
