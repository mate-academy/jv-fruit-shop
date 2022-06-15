package core.basesyntax.strategy.transaction;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public int getAmount(int amount, int newAmount) {
        return newAmount;
    }
}
