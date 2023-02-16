package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.fruits.get(fruitTransaction.getFruit());
        if (oldQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        Storage.fruits.put(
                fruitTransaction.getFruit(), oldQuantity - fruitTransaction.getQuantity());
    }
}
