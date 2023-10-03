package core.basesyntax.strategy;

public class ReturnOperationStrategy implements OperationStrategy {
    private static final int AMOUNT_INDEX = 2;

    @Override
    public int getAmount(String[] reportLine) {
        return Integer.parseInt(reportLine[AMOUNT_INDEX]);
    }
}
