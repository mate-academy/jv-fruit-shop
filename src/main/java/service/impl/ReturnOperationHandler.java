package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        final String fruit = transaction.getFruit();
        final int newBalance = Storage.STORAGE.get(fruit) + transaction.getQuantity();
        Storage.STORAGE.put(fruit, newBalance);
    }
}
