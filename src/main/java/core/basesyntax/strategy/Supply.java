package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class Supply implements OperationHandler {
    @Override
    public void handleFruitOperation(String fruit, Integer quantity) {
        if (Storage.fruits.containsKey(fruit)) {
            Storage.put(fruit, Storage.get(fruit) + quantity);
            return;
        }
        Storage.put(fruit, quantity);
    }
}
