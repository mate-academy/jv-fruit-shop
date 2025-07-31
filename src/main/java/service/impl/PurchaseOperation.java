package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int current = Storage.get(transaction.getFruit());
        int newQty = current - transaction.getQuantity();
        if (newQty < 0) {
            throw new IllegalArgumentException("Not enough " + transaction.getFruit());
        }
        Storage.put(transaction.getFruit(), newQty);
    }

}
