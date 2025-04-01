package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class SupplyHandler implements OperationStrategy {
    @Override
    public void execute(String fruit, int quantity) {
        Storage.inventory.put(fruit, Storage.inventory.getOrDefault(fruit, 0) + quantity);
    }

    @Override
    public boolean isValid(String fruit, int quantity) {
        return quantity > 0;
    }
}
