package core.basesyntax.strategy.transaction;

public class AddingTransactionHandler implements TransactionHandler {
    @Override
    public int getAmount(int amount, int newAmount) {
        return amount + newAmount;
    }
}
