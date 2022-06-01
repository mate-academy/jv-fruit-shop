package core.basesyntax.strategy;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public int dayResult(int numberOfFruitsInTheStore, int numberOfFruitsTransaction) {
        return numberOfFruitsInTheStore - numberOfFruitsTransaction;
    }
}
