package strategy.impl;

import db.Warehouse;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class PurchaseImpl implements TransactionHandler {

    @Override
    public void getTransaction(FruitTransaction transaction) {
        int actual = Warehouse.STORAGE.get(transaction.getFruit());
        int subtraction = actual - transaction.getQuantity();
        if (subtraction < 0) {
            throw new RuntimeException("The storage of " + transaction.getFruit()
                    + "can't be negative." + " If it equals "
                    + actual + " we can't purchased " + transaction.getQuantity());
        }
        Warehouse.STORAGE.put(transaction.getFruit(), subtraction);
    }
}
