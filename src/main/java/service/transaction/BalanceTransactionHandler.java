package service.transaction;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public int getTransactionResult(int currentValue, int transactionValue) {
        return transactionValue;
    }
}
