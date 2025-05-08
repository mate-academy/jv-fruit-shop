package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void updateNumberOffFruit(String fruit, int amount) {
        Storage.storage.put(fruit, Storage.storage.getOrDefault(fruit, 0) - amount);
        if (amount < 0) {
            throw new RuntimeException("Fruit quantity isn’t enough!");
        }
    }
}
