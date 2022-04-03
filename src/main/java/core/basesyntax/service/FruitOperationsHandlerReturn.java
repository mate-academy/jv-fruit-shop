package core.basesyntax.service;

public class FruitOperationsHandlerReturn implements FruitOperationsHandler {
    @Override
    public int getResultOfFruitOperation(int sum, int quantity) {
        return sum + quantity;
    }
}
