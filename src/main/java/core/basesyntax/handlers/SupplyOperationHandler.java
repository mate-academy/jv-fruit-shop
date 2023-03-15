package core.basesyntax.handlers;

import core.basesyntax.db.Storage;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void apply(String fruit, Integer quantity) {
        if (Storage.get(fruit) == null) {
            Storage.put(fruit, quantity);
        }
        Storage.put(fruit, Storage.get(fruit) + quantity);
    }
}
