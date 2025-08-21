package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.fruits.getOrDefault(fruit, DEFAULT_VALUE);
        int toBuy = transaction.getQuantity();

        if (currentQuantity < toBuy) {
            throw new RuntimeException("Not enough " + fruit
                    + " in shop. Available: " + currentQuantity
                    + ", requested: " + toBuy);
        }

        Storage.fruits.put(fruit, currentQuantity - toBuy);
    }
}
