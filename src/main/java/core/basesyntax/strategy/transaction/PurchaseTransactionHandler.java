package core.basesyntax.strategy.transaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public int getTransactionResult(int oldQuantity, int transactionQuantity) {
        return oldQuantity - transactionQuantity;
    }
}
