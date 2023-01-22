package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(),
                Storage.fruits.containsKey(transaction.getFruit())
                ? Storage.fruits.get(transaction.getFruit()) + transaction.getQuantity()
                : transaction.getQuantity());
    }
}
