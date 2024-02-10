package core.basesyntax.strategy;

public class TransactionStrategyPurchaseImpl implements TransactionStrategy {
    @Override
    public int balanceUpdater(int balance, String quantity) {
        int result = balance - Integer.parseInt(quantity);
        if (result < 0) {
            throw new RuntimeException("Balance couldn't be less '0'"
                    + " after purchase: balance = " + result);
        } else if (Integer.parseInt(quantity) < 0) {
            throw new RuntimeException("Purchased quantity couldn't be less '0'.\n"
                    + "Invalid data received from input file: purchase = " + quantity);
        }
        return result;
    }
}
