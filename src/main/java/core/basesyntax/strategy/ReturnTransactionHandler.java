package core.basesyntax.strategy;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public int dayResult(int numberOfFruitsInTheStore, int numberOfFruitsTransaction) {
        return numberOfFruitsInTheStore + numberOfFruitsTransaction;
    }
}
