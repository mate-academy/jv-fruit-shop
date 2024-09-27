package core.basesyntax.strategy.transaction;

public interface TransactionHandler {
    int getTransactionResult(int oldQuantity, int transactionQuantity);
}
