package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int initialQuantity = Storage.STORAGE.get(fruitTransaction.getFruit());
        Storage.STORAGE.put(
                fruitTransaction.getFruit(), initialQuantity + fruitTransaction.getQuantity());
    }
}
