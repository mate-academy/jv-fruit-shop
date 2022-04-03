package core.basesyntax.service;

public class FruitOperationsHandlerSupply implements FruitOperationsHandler {
    @Override
    public int getResultOfFruitOperation(int sum, int quantity) {
        return sum + quantity;
    }
}
