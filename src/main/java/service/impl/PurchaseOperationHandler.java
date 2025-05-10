package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final FruitBalanceCheckService FRUIT_BALANCE_CHECK_SERVICE
            = new FruitBalanceCheckService();

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        final String fruit = transaction.getFruit();
        final int newBalance = Storage.STORAGE.get(fruit) - transaction.getQuantity();
        FRUIT_BALANCE_CHECK_SERVICE.checkNegativeBalance(newBalance, fruit);
        Storage.STORAGE.put(fruit, newBalance);
    }
}
