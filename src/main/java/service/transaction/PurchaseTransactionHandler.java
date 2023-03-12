package service.transaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public int getTransactionResult(int currentValue, int transactionValue) {
        return currentValue - transactionValue;
    }
}
