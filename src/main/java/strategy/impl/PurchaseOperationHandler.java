package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void calculate(FruitTransaction transaction) {
        if (Storage.fruits.get(transaction.getFruit()) == null
                || Storage.fruits.get(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("Not enough "
                    + transaction.getFruit() + " in storage to purchase. "
                    + transaction.getFruit() + " in storage - "
                    + Storage.fruits.get(transaction.getFruit()));
        }
        Storage.fruits.put(transaction.getFruit(),
                Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity());
    }
}
