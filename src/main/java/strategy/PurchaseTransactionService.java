package strategy;

public class PurchaseTransactionService implements TransactionService {
    @Override
    public int dayResult(int numberOfFruitsInTheStore, int numberOfFruitsTransaction) {
        return numberOfFruitsInTheStore - numberOfFruitsTransaction;
    }
}
