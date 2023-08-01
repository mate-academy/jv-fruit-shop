package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        int totalQuantityOfFruit = Storage.STORAGE.get(fruitTransaction.getFruit());
        int returnedQuantity = fruitTransaction.getQuantity() + totalQuantityOfFruit;
        Storage.STORAGE.put(fruitTransaction.getFruit(), returnedQuantity);
    }
}
