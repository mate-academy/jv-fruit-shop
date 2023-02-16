package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.ActivityHandler;

public class BalanceActivityHandler implements ActivityHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        FruitStorage.fruitStorage.put(transaction.getFruit(), transaction.getAmount());
    }
}
