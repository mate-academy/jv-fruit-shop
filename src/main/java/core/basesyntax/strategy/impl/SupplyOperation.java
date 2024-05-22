package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(Storage storage, FruitTransaction transaction) {
        storage.change(transaction.getFruit(),
                storage.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
