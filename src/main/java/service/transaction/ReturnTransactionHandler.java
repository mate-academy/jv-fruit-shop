package service.transaction;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public int getTransactionResult(int currentValue, int transactionValue) {
        return currentValue + transactionValue;
    }
}
