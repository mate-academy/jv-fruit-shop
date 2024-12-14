package core.basesyntax.strategy;

import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void apply(String fruit, int quantity) {
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + quantity);
    }
}
