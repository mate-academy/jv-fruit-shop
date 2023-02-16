package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.fruits.get(fruitTransaction.getFruit());
        Storage.fruits.put(
                fruitTransaction.getFruit(), oldQuantity + fruitTransaction.getQuantity());
    }
}
