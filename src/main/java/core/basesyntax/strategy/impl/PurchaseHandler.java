package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
