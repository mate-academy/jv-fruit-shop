package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int balance = transaction.getQuantity();
        if (balance < 0) {
            throw new RuntimeException("Balance can't be negative: " + balance);
        }
        FruitStorage.fruits.put(transaction.getFruit(), balance);
    }
}
