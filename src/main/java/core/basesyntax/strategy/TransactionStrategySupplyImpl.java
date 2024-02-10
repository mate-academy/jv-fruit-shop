package core.basesyntax.strategy;

public class TransactionStrategySupplyImpl implements TransactionStrategy {
    @Override
    public int balanceUpdater(int balance, String quantity) {
        int result = balance + Integer.parseInt(quantity);
        if (result < 0) {
            throw new RuntimeException("Balance couldn't be less '0'"
                    + " after supple: balance = " + result);
        } else if (Integer.parseInt(quantity) < 0) {
            throw new RuntimeException("Supplied quantity couldn't be less '0'."
                    + "Invalid data received from input file: supply = " + quantity);
        }
        return result;
    }
}
