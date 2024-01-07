package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(String fruit, int quantity, Storage storage) {
        int currentQuantity = storage.getFruitQuantities().get(fruit);
        if (currentQuantity >= quantity) {
            storage.getFruitQuantities().put(fruit, currentQuantity - quantity);
        } else {
            throw new RuntimeException("Insufficient quantity for purchase: " + fruit);
        }
    }

}
