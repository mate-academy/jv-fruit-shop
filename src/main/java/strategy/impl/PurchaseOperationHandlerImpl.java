package strategy.impl;

import db.FruitStorage;
import fruitscontent.FruitsContent;
import strategy.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitsContent transaction) {
        int oldQuantity = FruitStorage.fruits.get(transaction.getFruit());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " for purchase!");
        }
        FruitStorage.fruits.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}
