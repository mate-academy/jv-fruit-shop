package core.basesyntax.strategy;

public class FruitOperationsHandlerBalance implements FruitOperationsHandler {
    @Override
    public int getResultOfFruitOperation(int sum, int quantity) {
        return sum + quantity;
    }
}
