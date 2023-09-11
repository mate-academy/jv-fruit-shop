package strategy.impl;

import db.Warehouse;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class BalanceImpl implements TransactionHandler {

    @Override
    public void getTransaction(FruitTransaction transaction) {
        Warehouse.STORAGE.put(transaction.getFruit(), transaction.getQuantity());
    }
}
