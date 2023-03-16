package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(String fruit, Integer quantity) {
        if (Storage.get(fruit) < quantity) {
            throw new RuntimeException(
                "Not enough fruits in storage. Remained only " + Storage.get(fruit));
        }
        Storage.put(fruit, Storage.get(fruit) - quantity);
    }
}
