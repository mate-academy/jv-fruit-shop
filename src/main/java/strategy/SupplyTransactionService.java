package strategy;

public class SupplyTransactionService implements TransactionService {
    @Override
    public int dayResult(int numberOfFruitsInTheStore, int numberOfFruitsTransaction) {
        return numberOfFruitsInTheStore + numberOfFruitsTransaction;
    }
}
