package core.basesyntax.strategy.transaction;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public int getTransaction(int oldQuantity, int transactionQuantity) {
        return oldQuantity + transactionQuantity;
    }
}
