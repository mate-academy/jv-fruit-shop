package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class TransactionStrategyImpl implements TransactionStrategy {
    @Override
    public Integer balanceUpdater(String fruitName, int quantity) {
        Storage storage = new Storage();
        if (quantity < 0) {
            throw new RuntimeException("Balance couldn't be less '0'.\n"
                    + " Invalid data received from input file: balance "
                    + fruitName + " = " + quantity);
        }
        storage.getFruitsTransactions().put(fruitName, quantity);
        return quantity;
    }
}
