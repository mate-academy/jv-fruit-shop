package core.basesyntax.Operation;

import core.basesyntax.Model.FruitTransaction;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = storage.getOrDefault(fruit, 0);

        if (currentQuantity < transaction.getQuantity()) {
            throw new IllegalArgumentException("Not enough " + fruit + " in storage");
        }
        storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}
