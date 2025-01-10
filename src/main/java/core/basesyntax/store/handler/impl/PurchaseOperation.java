package core.basesyntax.store.handler.impl;

import core.basesyntax.store.Storage;
import core.basesyntax.store.handler.OperationHandler;
import core.basesyntax.store.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Storage.modifyFruitStorage(fruitTransaction.getFruit(), -fruitTransaction.getQuantity());
    }
}
