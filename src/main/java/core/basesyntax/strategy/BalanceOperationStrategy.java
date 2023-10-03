package core.basesyntax.strategy;

public class BalanceOperationStrategy implements OperationStrategy {
    private static final int AMOUNT_INDEX = 2;

    @Override
    public int getAmount(String[] reportLine) {
        if (Integer.parseInt(reportLine[AMOUNT_INDEX]) < 0) {
            throw new RuntimeException("balance is negative");
        }
        return Integer.parseInt(reportLine[AMOUNT_INDEX]);
    }
}
