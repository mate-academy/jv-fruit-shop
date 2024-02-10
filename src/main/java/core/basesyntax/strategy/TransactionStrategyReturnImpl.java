package core.basesyntax.strategy;

public class TransactionStrategyReturnImpl implements TransactionStrategy {
    @Override
    public int balanceUpdater(int balance, String quantity) {
        int result = balance + Integer.parseInt(quantity);
        if (result < 0) {
            throw new RuntimeException("Balance couldn't be less '0' "
                    + "after returned: balance = " + result);
        } else if (Integer.parseInt(quantity) < 0) {
            throw new RuntimeException("Returned quantity couldn't be less '0'.\n"
                    + "Invalid data received from input file: return = " + quantity);
        }
        return result;
    }
}
