package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class Return implements OperationHandler {
    @Override
    public void operationWithFruits(String fruit, Integer quantity) {
        if (Storage.fruits.containsKey(fruit)) {
            Storage.put(fruit, Storage.get(fruit) + quantity);
            return;
        }
        Storage.put(fruit, quantity);
    }
}
