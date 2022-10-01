package core.basesyntax.strategy;

public class PurchaseOperationStrategy implements OperationStrategy {
    @Override
    public int calculate(final int number) {
        return number * (-1);
    }
}
