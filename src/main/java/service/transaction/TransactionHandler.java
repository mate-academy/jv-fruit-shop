package service.transaction;

public interface TransactionHandler {
    int getTransactionResult(int currentValue, int transactionValue);
}
