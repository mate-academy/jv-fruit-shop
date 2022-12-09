package strategy.handler.impl;

import model.FruitTransaction;
import strategy.handler.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public FruitTransaction getOperationResult(FruitTransaction fruitTransaction) {
        int fruitQuantity = fruitTransaction.getQuantity();
        fruitTransaction.setQuantity(-fruitQuantity);
        return fruitTransaction;
    }
}
