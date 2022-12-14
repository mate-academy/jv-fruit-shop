package service.strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        int newValue = Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity();
        Storage.fruits.put(transaction.getFruit(), newValue);
    }
}

