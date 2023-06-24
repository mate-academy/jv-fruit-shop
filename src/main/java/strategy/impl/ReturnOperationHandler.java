package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int balance = FruitStorage.fruits.get(transaction.getFruit());
        FruitStorage.fruits.put(transaction.getFruit(), balance + transaction.getQuantity());
    }
}
