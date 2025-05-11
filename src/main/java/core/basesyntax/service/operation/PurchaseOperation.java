package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void updateNumberOffFruit(String fruit, int amount) {
        if (Storage.storage.getOrDefault(fruit, 0) - amount < 0) {
            throw new RuntimeException("Not enough fruit quality!");
        }
        Storage.storage.put(fruit, Storage.storage.getOrDefault(fruit, 0) - amount);
    }
}
