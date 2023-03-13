package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationImpl implements OperationHandler {
    private static final int DEFAULT_QUANTITY = 0;

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int amount = Storage.getOrDefault(fruitTransaction.getFruit(), DEFAULT_QUANTITY);
        int purchaseResult = amount - fruitTransaction.getQuantity();
        if (purchaseResult < 0) {
            throw new RuntimeException("Invalid quantity for purchase,"
                    + "you can't buy more than we have");
        }
        Storage.put(fruitTransaction.getFruit(), purchaseResult);
    }
}
