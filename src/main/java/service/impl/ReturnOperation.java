package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int current = Storage.get(transaction.getFruit());
        Storage.put(transaction.getFruit(), current + transaction.getQuantity());
    }
}
