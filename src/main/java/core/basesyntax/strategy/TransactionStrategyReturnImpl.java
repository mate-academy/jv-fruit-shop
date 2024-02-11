package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class TransactionStrategyReturnImpl implements TransactionStrategy {
    @Override
    public Integer balanceUpdater(String fruitName, int quantity) {
        Storage storage = new Storage();
        if (storage.getFruitsTransactions().get(fruitName) != null) {
            int result = storage.getFruitsTransactions().get(fruitName) + quantity;
            if (result < 0) {
                throw new RuntimeException("Balance couldn't be less '0' "
                        + "after returned: balance " + fruitName + " = " + result);
            } else if (quantity < 0) {
                throw new RuntimeException("Returned quantity couldn't be less '0'.\n"
                        + "Invalid data received from input file: return "
                        + fruitName + " = " + quantity);
            }
            storage.getFruitsTransactions().put(fruitName, result);
            return result;
        }
        throw new RuntimeException("This fruit: " + fruitName
                + " has not been sold and cannot be returned.");
    }
}
