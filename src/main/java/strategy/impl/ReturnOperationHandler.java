package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        int currentQty = Storage.fruitsStorage.get(fruitTransaction.getFruit());
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),
                currentQty + fruitTransaction.getQuantity());
    }
}
