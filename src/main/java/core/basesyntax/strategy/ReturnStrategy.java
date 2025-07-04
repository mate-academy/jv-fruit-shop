package core.basesyntax.strategy;

public class ReturnStrategy implements QuantityCalculationStrategy {
    @Override
    public int calculate(int quantity) {
        return quantity;
    }
}
