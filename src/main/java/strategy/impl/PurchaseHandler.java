package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operateFruits(FruitTransaction transaction) {
        if (transaction == null || transaction.getFruit() == null
                || transaction.getQuantity() < 0) {
            throw new RuntimeException("Invalid information can't be add to Storage");
        }
        if (!Storage.fruits.containsKey(transaction.getFruit())) {
            throw new RuntimeException("We don't have such fruit " + transaction.getFruit()
                    + " in our shop");
        }
        if (Storage.get(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("We don't have enough "
                    + transaction.getFruit() + " in our shop. We have only "
                    + Storage.get(transaction.getFruit()) + " " + transaction.getFruit()
                    + ", but you want to take " + transaction.getQuantity());
        }
        Storage.put(transaction.getFruit(),
                Storage.get(transaction.getFruit()) - transaction.getQuantity());
    }
}
