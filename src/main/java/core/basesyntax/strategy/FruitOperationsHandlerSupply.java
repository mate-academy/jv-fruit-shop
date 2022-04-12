package core.basesyntax.strategy;

public class FruitOperationsHandlerSupply implements FruitOperationsHandler {
    @Override
    public int handle(int sum, int quantity) {
        return sum + quantity;
    }
}
