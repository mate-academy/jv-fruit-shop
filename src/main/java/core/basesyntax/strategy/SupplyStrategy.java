package core.basesyntax.strategy;

public class SupplyStrategy implements QuantityCalculationStrategy {
    @Override
    public int calculate(int quantity) {
        return quantity;
    }
}
