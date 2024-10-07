package core.basesyntax.service;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements FruitOperationHandler {
    @Override
    public void getFruitOperation(FruitTransaction transaction, Inventory inventory) {
        inventory.getInventory().put(transaction.getFruit(),
                inventory.getInventory().getOrDefault(
                        transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
