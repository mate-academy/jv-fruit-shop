package core.basesyntax.strategy.transaction;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public int getTransactionResult(int oldQuantity, int transactionQuantity) {
        return oldQuantity + transactionQuantity;
    }
}
