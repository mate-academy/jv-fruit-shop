package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
