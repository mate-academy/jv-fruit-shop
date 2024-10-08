package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Inventory;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Inventory inventory) {
        int currentBalance = inventory.getInventory().getOrDefault(transaction.getFruit(), 0);
        int newBalance = currentBalance - transaction.getQuantity();

        if (newBalance < 0) {
            throw new RuntimeException(
                    "Cannot complete purchase: insufficient stock for " + transaction.getFruit());
        }

        inventory.getInventory().put(transaction.getFruit(), newBalance);
    }
}
