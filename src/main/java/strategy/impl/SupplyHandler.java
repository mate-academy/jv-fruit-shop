package strategy.impl;

import static db.Storage.modifyFruitStock;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.getFruitStock().getOrDefault(transaction.getFruit(), 0);
        modifyFruitStock(transaction.getFruit(),
                currentQuantity + transaction.getQuantity());
    }
}
