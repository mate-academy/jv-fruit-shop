package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.ActivityHandler;

public class SupplyActivityHandler implements ActivityHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentAmount = FruitStorage.fruitStorage.get(transaction.getFruit());
        FruitStorage.fruitStorage.put(
                transaction.getFruit(), currentAmount + transaction.getAmount());
    }
}
