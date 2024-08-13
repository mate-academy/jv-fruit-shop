package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction, Storage storage) {
        storage.getInventory().merge(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(),
                Integer::sum
        );
    }
}
