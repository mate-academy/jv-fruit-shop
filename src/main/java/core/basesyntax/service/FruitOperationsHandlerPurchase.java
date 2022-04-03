package core.basesyntax.service;

public class FruitOperationsHandlerPurchase implements FruitOperationsHandler {
    @Override
    public int getResultOfFruitOperation(int sum, int quantity) {
        return sum - quantity;
    }
}
