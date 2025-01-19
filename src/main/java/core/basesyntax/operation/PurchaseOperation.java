package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentQuantity = Storage.getQuantity(fruit);

        if (currentQuantity < quantity) {
            throw new IllegalStateException("Not enough " + fruit + " in storage");
        }
        Storage.put(fruit, currentQuantity - quantity);
    }
}
