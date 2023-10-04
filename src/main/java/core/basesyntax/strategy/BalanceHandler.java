package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void calculate(FruitTransaction transaction) {
        if (transaction.getQuantity() > 0) {
            Storage.fruitInventory.put(transaction.getFruit(), transaction.getQuantity());
        } else {
            throw new RuntimeException(
                    "Balance can't be negative, but was " + transaction.getQuantity());
        }
    }
}
