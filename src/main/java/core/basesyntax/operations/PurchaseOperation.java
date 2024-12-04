package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (!Storage.fruits.containsKey(fruit)) {
            throw new IllegalArgumentException("Fruit: " + fruit + " is not available");
        }
        int currentQuantity = Storage.fruits.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit + "in the storage");
        }
        Storage.fruits.put(fruit, currentQuantity - quantity);
    }
}
