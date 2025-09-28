package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int current = Storage.inventory.getOrDefault(fruit, 0);
        if (current < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit + " in stock");
        }
        Storage.inventory.put(fruit, current - quantity);
    }
}
