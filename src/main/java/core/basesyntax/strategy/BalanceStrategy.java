package core.basesyntax.strategy;

public class BalanceStrategy implements QuantityCalculationStrategy {
    @Override
    public int calculate(int quantity) {
        return quantity;
    }
}
