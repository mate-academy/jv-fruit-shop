package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        final int quantity = transaction.getQuantity();
        final String fruit = transaction.getFruit();
        if (Storage.STORAGE.containsKey(fruit)) {
            final int newBalance = Storage.STORAGE.get(fruit) + quantity;
            Storage.STORAGE.put(fruit, newBalance);
        } else {
            Storage.STORAGE.put(fruit, quantity);
        }
    }
}
