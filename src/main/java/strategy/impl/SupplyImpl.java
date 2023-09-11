package strategy.impl;

import db.Warehouse;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class SupplyImpl implements TransactionHandler {

    @Override
    public void getTransaction(FruitTransaction transaction) {
        Warehouse.STORAGE.put(transaction.getFruit(), Warehouse.STORAGE.get(transaction.getFruit())
                + transaction.getQuantity());
    }
}
