package core.basesyntax.stategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.stategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.FRUITS.get(fruitTransaction.getFruit());
        Storage.FRUITS.put(
                fruitTransaction.getFruit(), oldQuantity + fruitTransaction.getQuantity());
    }
}
