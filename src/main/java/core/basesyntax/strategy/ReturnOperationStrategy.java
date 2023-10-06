package core.basesyntax.strategy;

public class ReturnOperationStrategy implements OperationStrategy {
    private static final int AMOUNT_INDEX = 2;

    @Override
    public int getAmount(int amount) {
        return amount;
    }
}
