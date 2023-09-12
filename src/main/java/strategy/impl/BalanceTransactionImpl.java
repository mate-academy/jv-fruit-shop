package strategy.impl;

import db.Warehouse;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class BalanceTransactionImpl implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Warehouse.STORAGE.put(transaction.getFruit(), transaction.getQuantity());
    }
}
