package service.transaction;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public int getTransactionResult(int currentValue, int transactionValue) {
        return currentValue + transactionValue;
    }
}
