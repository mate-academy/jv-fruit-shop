package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

import java.util.Map;

public class TransactionStrategySupplyImpl implements TransactionStrategy {
    @Override
    public Integer balanceUpdater(String fruitName, int quantity) {
        if (Storage.fruitsTransactions.get(fruitName) != null) {
            int result = Storage.fruitsTransactions.get(fruitName) + quantity;
            if (result < 0) {
                throw new RuntimeException("Balance couldn't be less '0' "
                        + "after returned: balance " + fruitName + " = " + result);
            } else if (quantity < 0) {
                throw new RuntimeException("Returned quantity couldn't be less '0'.\n"
                        + "Invalid data received from input file: return " + fruitName + " = " + quantity);
            }
            Storage.fruitsTransactions.put(fruitName, result);
            return result;
        }
        Storage.fruitsTransactions.put(fruitName, quantity);
        return quantity;
    }
}


