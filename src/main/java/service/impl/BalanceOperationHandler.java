package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Storage.STORAGE.put(transaction.getFruit(), transaction.getQuantity());
    }
}
