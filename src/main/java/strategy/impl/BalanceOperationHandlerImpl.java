package strategy.impl;

import db.FruitStorage;
import fruitscontent.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitStorage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
