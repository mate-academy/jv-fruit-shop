package strategy;

public class ReturnTransactionService implements TransactionService {
    @Override
    public int dayResult(int numberOfFruitsInTheStore, int numberOfFruitsTransaction) {
        return numberOfFruitsInTheStore + numberOfFruitsTransaction;
    }
}
