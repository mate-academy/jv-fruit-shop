package core.basesyntax.strategy.transaction;

public interface TransactionHandler {
    int getTransaction(int oldQuantity, int transactionQuantity);
}
