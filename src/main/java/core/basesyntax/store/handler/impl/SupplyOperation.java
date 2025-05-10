package core.basesyntax.store.handler.impl;

import core.basesyntax.store.Storage;
import core.basesyntax.store.handler.OperationHandler;
import core.basesyntax.store.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Storage.modifyFruitStorage(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
