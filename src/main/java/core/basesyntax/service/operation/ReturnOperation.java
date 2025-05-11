package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void updateNumberOffFruit(String fruit, int amount) {
        Storage.storage.put(fruit, Storage.storage.getOrDefault(fruit, 0) + amount);
    }
}
