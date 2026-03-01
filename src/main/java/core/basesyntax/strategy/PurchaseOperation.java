package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        int current = Storage.get(fruit);

        if (current < quantity) {
            throw new RuntimeException(
                    "Not enough " + fruit + " in storage. Available: "
                            + current + ", requested: " + quantity
            );
        }

        Storage.put(fruit, current - quantity);
    }
}
