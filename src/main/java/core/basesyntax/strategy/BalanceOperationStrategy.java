package core.basesyntax.strategy;

public class BalanceOperationStrategy implements OperationStrategy {
    private static final int AMOUNT_INDEX = 2;

    @Override
    public int getAmount(int amount) {
        if (amount < 0) {
            throw new RuntimeException("balance is negative");
        }
        return amount;
    }
}
