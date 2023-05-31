package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void calculate(FruitTransaction transaction) {
        int currentAmount = Storage.fruitInventory.get(transaction.getFruit());
        if (currentAmount >= transaction.getQuantity()) {
            Storage.fruitInventory
                    .put(transaction.getFruit(), currentAmount
                            - transaction.getQuantity());
        } else {
            throw new RuntimeException(
                    "Quantity is not enough to make this purchase, should be at least "
                    + transaction.getQuantity()
                    + " but was "
                    + currentAmount);
        }
    }
}
