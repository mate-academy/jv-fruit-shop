package core.basesyntax.strategy;

public class BalanceOperationStrategy implements OperationStrategy {
    @Override
    public int calculate(final int total, final int number) {
        return total + number;
    }
}
