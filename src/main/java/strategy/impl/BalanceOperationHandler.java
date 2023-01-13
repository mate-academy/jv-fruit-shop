package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        FruitStorage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
