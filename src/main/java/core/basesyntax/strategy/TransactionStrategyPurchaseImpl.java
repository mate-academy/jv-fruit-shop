package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class TransactionStrategyPurchaseImpl implements TransactionStrategy {
    @Override
    public Integer balanceUpdater(String fruitName, int quantity) {
        int result = Storage.fruitsTransactions.get(fruitName) - quantity;
        if (result < 0) {
            throw new RuntimeException("Balance couldn't be less '0'"
                    + " after purchase: balance " + fruitName + " = " + result);
        } else if (quantity < 0) {
            throw new RuntimeException("Purchased quantity couldn't be less '0'.\n"
                    + "Invalid data received from input file: purchase "
                    + fruitName + " = " + quantity);
        }
        Storage.fruitsTransactions.put(fruitName, result);
        return result;
    }
}
