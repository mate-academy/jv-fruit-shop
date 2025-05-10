package strategy.impl;

import db.FruitsStorage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int oldQuantity = FruitsStorage.fruitsStorage.get(fruitTransaction.getName());
        if (oldQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough " + fruitTransaction.getName()
                    + " for purchase!");
        }
        FruitsStorage.fruitsStorage.put(fruitTransaction.getName(),
                oldQuantity - fruitTransaction.getQuantity());
    }
}
