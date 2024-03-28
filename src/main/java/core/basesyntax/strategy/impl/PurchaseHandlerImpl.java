package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int quantityBefore = Storage.fruits.get(transaction.getFruit());
        Storage.fruits.put(transaction.getFruit(), quantityBefore - transaction.getQuantity());
    }
}
