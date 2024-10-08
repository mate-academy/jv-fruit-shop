package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Inventory;

public class ReturnOperation implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Inventory inventory) {
        inventory.getInventory().put(transaction.getFruit(),
                inventory.getInventory().getOrDefault(
                        transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
