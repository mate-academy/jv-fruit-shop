package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationStrategy {
    @Override
    public void execute(String fruit, int quantity) {
        int currentQuantity = Storage.inventory.getOrDefault(fruit, 0);
        if (currentQuantity >= quantity) {
            Storage.inventory.put(fruit, currentQuantity - quantity);
        } else {
            throw new RuntimeException("Not enough product to purchase: " + fruit);
        }
    }
}
