package strategy.impl;

import db.FruitsStorage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int oldQuantity = FruitsStorage.fruitsStorage.get(fruitTransaction.getName());
        FruitsStorage.fruitsStorage.put(fruitTransaction.getName(),
                oldQuantity + fruitTransaction.getQuantity());
    }
}
