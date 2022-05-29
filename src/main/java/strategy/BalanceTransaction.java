package strategy;

public class BalanceTransaction implements TransactionService {
    @Override
    public int dayResult(int numberOfFruitsInTheStore, int numberOfFruitsTransaction) {
        return numberOfFruitsTransaction;
    }
}
