package strategy.impl;

import db.FruitStorage;
import fruitscontent.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        int oldQuantity = FruitStorage.fruits.get(transaction.getFruit());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " for purchase!");
        }
        FruitStorage.fruits.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}
