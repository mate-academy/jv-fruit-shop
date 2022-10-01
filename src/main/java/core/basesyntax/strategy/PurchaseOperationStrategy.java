package core.basesyntax.strategy;

public class PurchaseOperationStrategy implements OperationStrategy {
    @Override
    public int calculate(final int total, final int number) {
        return total - number;
    }
}
