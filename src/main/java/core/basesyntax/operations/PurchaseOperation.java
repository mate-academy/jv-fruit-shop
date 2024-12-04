package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruits = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (!Storage.fruits.containsKey(fruits)) {
           throw new IllegalArgumentException("Fruit: " + fruits + " is not available");
        }
        int currentQuantity = Storage.fruits.getOrDefault(fruits, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough " + fruits + "in the storage");
        }
        Storage.fruits.put(fruits, currentQuantity - quantity);
    }
}
