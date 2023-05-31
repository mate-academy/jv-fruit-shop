package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void calculate(FruitTransaction transaction) {
        int currentAmount = Storage.fruitInventory.get(transaction.getFruit());
        if (currentAmount >= 0) {
            Storage.fruitInventory
                    .put(transaction.getFruit(), currentAmount
                            + transaction.getQuantity());
        } else {
            throw new RuntimeException(
                    "Balance can't be negative, but was " + transaction.getQuantity());
        }
    }
}
