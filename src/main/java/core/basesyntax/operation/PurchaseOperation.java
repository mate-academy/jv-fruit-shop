package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.storage.getOrDefault(fruit, 0);

        if (currentQuantity < transaction.getQuantity()) {
            throw new IllegalArgumentException("Not enough " + fruit + " in storage");
        }
        Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}
