package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction transaction) {
        Storage.getDb().put(transaction.getFruit(), transaction.getQuantity());
    }
}
