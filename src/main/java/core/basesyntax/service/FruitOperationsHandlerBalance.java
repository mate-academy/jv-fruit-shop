package core.basesyntax.service;

public class FruitOperationsHandlerBalance implements FruitOperationsHandler {
    @Override
    public int getResultOfFruitOperation(int sum, int quantity) {
        return sum + quantity;
    }
}
