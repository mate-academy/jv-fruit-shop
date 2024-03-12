package core.basesyntax.strategy.transaction;

public class BalanceTransactionHandler implements TransactionHandler {

    @Override
    public int getTransactionResult(int oldQuantity, int transactionQuantity) {
        return transactionQuantity;
    }
}
