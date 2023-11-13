package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(String fruit, Integer quantity) {
        if (Storage.get(fruit) == null) {
            Storage.put(fruit, quantity);
        }
        Storage.put(fruit, Storage.get(fruit) + quantity);
    }
}
