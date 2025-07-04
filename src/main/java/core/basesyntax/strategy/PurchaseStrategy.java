package core.basesyntax.strategy;

public class PurchaseStrategy implements QuantityCalculationStrategy {
    @Override
    public int calculate(int quantity) {
        return -quantity;
    }
}
