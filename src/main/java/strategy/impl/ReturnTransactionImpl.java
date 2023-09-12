package strategy.impl;

import db.Warehouse;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class ReturnTransactionImpl implements TransactionHandler {

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Warehouse.STORAGE.put(transaction.getFruit(), Warehouse.STORAGE.get(transaction.getFruit())
                + transaction.getQuantity());
    }
}
