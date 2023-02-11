package strategy.impl;

import db.FruitStorage;
import fruitscontent.FruitsContent;
import strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitsContent transaction) {
        int oldQuantity = FruitStorage.fruits.get(transaction.getFruit());
        FruitStorage.fruits.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
