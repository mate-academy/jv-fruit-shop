package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void operateFruits(FruitTransaction transaction) {
        if (transaction == null || transaction.getFruit() == null
                || transaction.getQuantity() < 0) {
            throw new RuntimeException("Invalid information can't be add to Storage");
        }
        if (Storage.getFruits().containsKey(transaction.getFruit())) {
            Storage.put(transaction.getFruit(), transaction.getQuantity()
                    + Storage.get(transaction.getFruit()));
        } else {
            Storage.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
