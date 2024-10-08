package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Inventory;

public class BalanceHandler implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Inventory inventory) {
        inventory.getInventory().put(transaction.getFruit(),
                Math.max(transaction.getQuantity(), 0));
    }
}
