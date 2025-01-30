package core.basesyntax.strategy.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentStock = Storage.fruitStorage.getOrDefault(fruit, 0);
        if (currentStock < quantity) {
            throw new IllegalArgumentException("Not enough stock for fruit: " + fruit
                    + ". Available: " + currentStock + ", required: " + quantity);
        }
        Storage.fruitStorage.put(fruit, currentStock - quantity);
    }
}
