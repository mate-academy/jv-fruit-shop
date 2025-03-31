package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class ReturnHandler implements OperationStrategy {
    @Override
    public void execute(String fruit, int quantity) {
        Storage.inventory.put(fruit, Storage.inventory.getOrDefault(fruit, 0) + quantity);
    }
}
